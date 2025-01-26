document.addEventListener("DOMContentLoaded", function () {
    fetch('history-data')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById("history-data");
            data.forEach(row => {
                const tr = document.createElement("tr");
                tr.innerHTML = `
                    <td>${row.id}</td>
                    <td>${row.firstNumber}</td>
                    <td>${row.operator}</td>
                    <td>${row.secondNumber}</td>
                    <td>${row.result}</td>
                `;
                tableBody.appendChild(tr);
            });
        })
        .catch(error => console.error("Błąd podczas pobierania danych:", error));
});
