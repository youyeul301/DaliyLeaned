const express = require('express');
const router = express.Router();
const FileController = require('../controller/file-controller');

router.get('/', FileController.searchAllFile);
router.get('/:filenum', FileController.searchFilesByFileNum);
router.post('/', FileController.uploadFile);
router.put('/:filenum',FileController.updateFile);
router.delete('/:filenum',FileController.deleteFile);

module.exports = router;