import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# part 1: load and explore the data

#  load the csv file
df = pd.read_csv("bibliotheque.csv")

#  convert date, entry time, and exit time to datetime format
df['Date'] = pd.to_datetime(df['Date'], errors='coerce')
df['Heure_entrée'] = pd.to_datetime(df['Heure_entrée'], format='%H:%M', errors='coerce')
df['Heure_sortie'] = pd.to_datetime(df['Heure_sortie'], format='%H:%M', errors='coerce')

#  create a column for visit duration in minutes
df['Durée_visite'] = (df['Heure_sortie'] - df['Heure_entrée']).dt.total_seconds() / 60

# show average visits per day and average visit duration
avg_visits_per_day = df.groupby('Date').size().mean()
avg_duration = df['Durée_visite'].mean()
print("average visits per day:", avg_visits_per_day)
print("average visit duration (minutes):", avg_duration)



#  remove rows where exit time is earlier than entry time
df = df[df['Heure_sortie'] >= df['Heure_entrée']]

#  remove duplicate rows
df = df.drop_duplicates()

# replace missing values in "type_utilisation" with "inconnu"
df['Type_utilisation'] = df['Type_utilisation'].fillna('Inconnu')

#  show first 5 rows to check the cleaned data
print(df.head())



# add a column for decimal hour of exit (e.g., 12:30 → 12.5)
df['Heure_de_sortie_num'] = df['Heure_sortie'].dt.hour + df['Heure_sortie'].dt.minute / 60

# add a column for time slot (morning, afternoon, evening)
def define_slot(hour):
    if hour < 12:
        return 'Matin'
    elif hour < 17:
        return 'Après-midi'
    else:
        return 'Soir'

df['Créneau_horaire'] = df['Heure_entrée'].dt.hour.apply(define_slot)

# group by field and usage type to get visit count and average time
grouped = df.groupby(['Filière', 'Type_utilisation']).agg(
    Nombre_visites=('Nom', 'count'),
    Temps_moyen=('Durée_visite', 'mean')
).reset_index()

# show the first 5 grouped results
print(grouped.head())



# line chart: number of visits per day
visits_per_day = df.groupby('Date').size()
visits_per_day.plot(kind='line', title='number of visits per day')
plt.xlabel("date")
plt.ylabel("number of visits")
plt.grid()
plt.show()

#  bar chart: number of visits by time slot
df['Créneau_horaire'].value_counts().plot(kind='bar', title='visits by time slot', color='green' )
plt.xlabel("time slot")
plt.ylabel("number of visits")
plt.grid()
plt.show()


#  convert duration and books borrowed to numpy arrays
durations = df['Durée_visite'].to_numpy()
books = df['Livres_empruntés'].to_numpy()

# calculate statistics and correlation
print("average duration:", np.mean(durations))
print("median duration:", np.median(durations))
print("standard deviation of duration:", np.std(durations))
print("correlation between duration and books:", np.corrcoef(durations, books)[0, 1])

#  create a random table (7 days x 4 time slots) to simulate visits
simulation = np.random.randint(5, 20, size=(7, 4))
total_per_day = simulation.sum(axis=1)
total_per_slot = simulation.sum(axis=0)

print("simulation (7 days x 4 slots):\n", simulation)
print("total visitors per day:", total_per_day)
print("total visitors per slot:", total_per_slot)
