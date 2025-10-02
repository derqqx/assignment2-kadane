import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv("../../results.csv", header=None)
data.columns = ["n","time","comparisons","accesses","iterations","updates","result","start","end"]

plt.plot(data["n"], data["time"], marker="o")
plt.xlabel("Input size (n)")
plt.ylabel("Execution time (ns)")
plt.title("Kadane Algorithm Performance")
plt.savefig("time_plot.png")

plt.plot(data["n"], data["comparisons"], marker="o")
plt.xlabel("Input size (n)")
plt.ylabel("Comparisons")
plt.title("Kadane Algorithm Comparisons")
plt.savefig("comparisons_plot.png")
