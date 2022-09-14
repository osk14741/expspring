const express = require("express");
const { default: helmet } = require("helmet");

const app = express();

app.use(helmet());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.get("/", (req, res) => {
    res.json("homepage");
});

module.exports = app;