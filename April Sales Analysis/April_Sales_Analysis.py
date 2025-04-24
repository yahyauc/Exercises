# Importing the required library
import matplotlib.pyplot as plt

# Defining the sales data
data = {
    "Mois" : ["Janvier", "fevrier", "Mars", "Avril"],
    "Produit A": [120, 150, 170, 200],
    "Produit B": [80, 100, 90, 130],
    "Produit C": [90, 110, 120, 140],
    "Region Nord": [100, 130, 150, 180],
    "Region Sud": [190, 210, 180, 220],
    "Region Est": [70, 80, 90, 100],
    "Region ouest": [110, 120, 130, 140]
}

# Getting the index of the month "Avril"
Mois = data["Mois"].index("Avril")

# List of products
prd = ["Produit A", "Produit B", "Produit C"]

# Extracting the sales values of each product in April
vt_avril = [data[Produit][Mois] for Produit in prd]

# Q1: Bar chart of product sales in April
plt.figure(figsize=(6, 3))  # Set the figure size
plt.bar(prd, vt_avril, color=['b', 'g', 'y'], width=0.3)  # Create a bar chart
plt.title("Ventes par produit en Avril")  # Title of the graph
plt.xlabel("prd")  # X-axis label
plt.ylabel("vt_avril")  # Y-axis label
plt.grid(axis='y', linestyle='--')  # Add horizontal grid lines
plt.tight_layout()  # Adjust the layout to prevent overlap
plt.show()  # Display the chart

# Space and text before the second chart
print("\n second chart: ")

# Pie chart showing the percentage of sales by product in April
plt.figure(figsize=(6, 6))  # Set the figure size
plt.pie(vt_avril, labels=prd, autopct='%1.1f%%', colors=['b', 'g', 'y'])  # Create a pie chart
plt.title("Répartition des ventes en Avril par produit")  # Title of the chart
plt.tight_layout()  # Adjust layout
plt.show()  # Display the chart
