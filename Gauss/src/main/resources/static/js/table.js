document.addEventListener("DOMContentLoaded", function() {
    fetch('/csv-data')
        .then(response => response.json())
        .then(data => {
            const tableContainer = d3.select("#table-container");
            const table = tableContainer.append("table");
            const thead = table.append("thead");
            const tbody = table.append("tbody");

            // Define columns
            const columns = ["edad", "altura", "peso", "nota", "genero"];

            // Append the header row
            thead.append("tr")
                .selectAll("th")
                .data(columns)
                .enter()
                .append("th")
                .text(d => d);

            // Create a row for each object in the data
            const rows = tbody.selectAll("tr")
                .data(data)
                .enter()
                .append("tr");

            // Create a cell in each row for each column
            rows.selectAll("td")
                .data(row => columns.map(column => row[column]))
                .enter()
                .append("td")
                .text(d => d);
        });
});