const width = 500;
const height = 300;
const svg = d3.select("#distribution-chart")
    .append("svg")
    .attr("width", width)
    .attr("height", height);

const bins = Array(10).fill(0);

function updateChart() {
    const x = d3.scaleLinear()
        .domain([0, bins.length])
        .range([0, width]);

    const y = d3.scaleLinear()
        .domain([0, d3.max(bins)])
        .range([height, 0]);

    const barWidth = width / bins.length;

    svg.selectAll("rect")
        .data(bins)
        .enter()
        .append("rect")
        .attr("x", (d, i) => x(i))
        .attr("y", d => y(d))
        .attr("width", barWidth - 1)
        .attr("height", d => height - y(d))
        .attr("fill", "steelblue");

    svg.selectAll("rect")
        .data(bins)
        .attr("y", d => y(d))
        .attr("height", d => height - y(d));
}

function simulateBallDrop() {
    const position = Math.floor(Math.random() * bins.length);
    bins[position]++;
    updateChart();
}

setInterval(simulateBallDrop, 100);