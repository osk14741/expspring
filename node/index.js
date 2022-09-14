const app = require("./app");
const port = process.env.PORT || 3000;

app.listen(port, () => {
    console.log("Listening on port " + port);
})

app.get("/api/data", (req, res) => {
    res.send("get data");
})

app.post("/api/data", (req, res) => {
    console.log(req.body);
    res.send("post data");
})

app.delete("/api/data/:id", (req, res) => {
    res.send(`delete data : ${req.params.id}`);
})