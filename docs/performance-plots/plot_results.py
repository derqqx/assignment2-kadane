import pandas as pd
import matplotlib.pyplot as plt
from pathlib import Path

csv_file = Path("C:/DAA/assignment2-kadane/results.csv")

data = pd.read_csv(csv_file)

output_dir = Path(__file__).parent

# График времени выполнения
plt.plot(data["n"], data["time_ns"], marker="o")
plt.xlabel("Input size (n)")
plt.ylabel("Execution time (ns)")
plt.title("Kadane Algorithm Performance")
plt.savefig(output_dir / "time_plot.png")
plt.clf()  # очищаем фигуру перед следующим графиком

# График количества сравнений
plt.plot(data["n"], data["comparisons"], marker="o")
plt.xlabel("Input size (n)")
plt.ylabel("Comparisons")
plt.title("Kadane Algorithm Comparisons")
plt.savefig(output_dir / "comparisons_plot.png")
