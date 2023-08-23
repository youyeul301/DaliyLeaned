const FileSercvice = require('../services/file-service')
const HttpStatus = require('http-status');
const FileDTO = require('../dto/file-dto');

exports.searchAllFile = async(req, res, next) =>{
    const results =await FileSercvice.searchAllFile();

    res.status(HttpStatus.OK).send({
        status: HttpStatus.OK,
        message: 'OK',
        results: results
    });
}

exports.searchFilesByFileNum = async(req, res, next) =>{
    const results =await FileSercvice.searchFilesByFileNum(req.params.filenum);

    if(results && results.length > 0) {
        res.status(HttpStatus.OK).send({
            status: HttpStatus.OK,
            message: 'OK',
            results: results
        });
    }

    if(results && results.length === 0) {

        res.status(HttpStatus.NOT_FOUND).send({
            status: HttpStatus.NOT_FOUND,
            message: 'NOT FOUND',
            code: -999999,
            results: [],
            links: [
                {
                    rel: 'menuRegist',
                    method: 'POST',
                    href: 'https://api.ohgiraffers.com/api/v1/menus'
                }
            ]
        });
    }
}

exports.uploadFile = async(req, res, next) =>{
    const results = await FileSercvice.uploadFile(new FileDTO(req.body));
    if(results) {
        res.status(HttpStatus.CREATED).send({
            status: HttpStatus.CREATED,
            message: 'CREATED',
            results : {
                attachName: results[0].attach_name,
                attachRename: results[0].attach_rename,
            },
            contentLocation: `/files/${results[0].attach_num}`
        });
    } else {
        res.status(HttpStatus.BAD_REQUEST).send({
            status: HttpStatus.BAD_REQUEST,
            message: 'BAD REQUEST',
            code: -888888,
            results: [],
            links: [
                {
                    rel:'menuRegist',
                    method: 'POST',
                    href: 'https://api.ohgiraffers.com/api/v1/menus'
                }
            ]
        });
    }
}

exports.updateFile = async(req, res, next) =>{
    
    const results = await FileSercvice.updateFile(req.params.filenum,new FileDTO(req.body));
    console.log(results)
    if(results) {
        res.status(HttpStatus.CREATED).send({
            status: HttpStatus.CREATED, 
            message: 'UPDATED',
            results : {
                attachName: results[0].attach_name,
                attachRename: results[0].attach_rename,
            },
            contentLocation: `/files/${results[0].attach_num}`
        });
    } else {
        res.status(HttpStatus.BAD_REQUEST).send({
            status: HttpStatus.BAD_REQUEST,
            message: 'BAD REQUEST',
            code: -888888,
            results: [],
            links: [
                {
                    rel:'menuRegist',
                    method: 'POST',
                    href: 'https://api.ohgiraffers.com/api/v1/menus'
                }
            ]
        });
    }
}

exports.deleteFile = async(req, res, next) =>{
    
    const results = await FileSercvice.deleteFile(req.params.filenum);
    console.log(results)
    if(results) {
        res.status(HttpStatus.OK).send({
            status: HttpStatus.OK, 
            message: 'DELETED',
            results : results,
        });
    } else {
        res.status(HttpStatus.BAD_REQUEST).send({
            status: HttpStatus.BAD_REQUEST,
            message: 'BAD REQUEST',
            code: -888888,
            results: [],
            links: [
                {
                    rel:'menuRegist',
                    method: 'POST',
                    href: 'https://api.ohgiraffers.com/api/v1/menus'
                }
            ]
        });
    }
}