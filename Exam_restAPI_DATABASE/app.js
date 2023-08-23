const express = require('express');

const app = express();

app.use(express.json());

const fileRouter = require('./src/routes/file-route');
app.use('/files', fileRouter);

app.listen(8888, () => console.log('Listening on port 8888'));