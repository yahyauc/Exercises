import numpy as np

# Creating the ADS array
# Columns: [Temperature (°C), Pressure (Pa), Humidity (%)]
ADS = np.array([
    [22.3, 101325, 45],
    [19.8, 100845, 50],
    [21.0, 101050, 47],
    [23.5, 100990, 48],
    [20.2, 101200, 49],
])

# Display array dimension
print("Dimension:")
print(ADS.ndim)

# Display shape of the array
print("Shape:")
print(ADS.shape)

# Display data type of the array elements
print("Data Type:")
print(ADS.dtype)

# Display total number of elements in the array
print("Total Elements:")
print(ADS.size)

# Extract and display the humidity column (3rd column)
print("Humidity Column:")
print(ADS[:, [2]])

# Basic statistical operations along columns
print("Mean of each column:")
print(np.mean(ADS, axis=0))

print("Median of each column:")
print(np.median(ADS, axis=0))

print("Variance of each column:")
print(np.var(ADS, axis=0))

print("Standard deviation of each column:")
print(np.std(ADS, axis=0))

# Minimum values along each column
print("Minimum of each column:")
print(np.min(ADS, axis=0))

# Maximum values along each column
print("Maximum of each column:")
print(np.max(ADS, axis=0))

# Extract rows where temperature is greater than 21°C
temp = ADS[:, 0]
print("Rows where temperature > 21°C:")
print(ADS[temp > 21])

# Convert temperature from Celsius to Fahrenheit and append as new column
Fahrenheit = temp * 9 / 5 + 32
ADS = np.column_stack((ADS, Fahrenheit))

# Delete the second column (Pressure) from the array
print("Array without Pressure column:")
print(np.delete(ADS, 1, axis=1))

# Multiply all elements in the array by 1.1 (example transformation)
print("All elements multiplied by 1.1:")
print(ADS * 1.1)

# Sum of each row
print("Sum of each row:")
print(np.sum(ADS, axis=1))

# Sum of each column
print("Sum of each column:")
print(np.sum(ADS, axis=0))

# Transpose of the array
print("Transpose of the array:")
print(ADS.T)

# Replace values > 300 with 300
print("Array with values > 300 capped at 300:")
print(np.where(ADS > 300, 300, ADS))
