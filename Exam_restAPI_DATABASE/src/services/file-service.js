const getConnection = require('../database/connection')
const FileRepository = require('../repositories/file-repo')
const FileDTO = require('../dto/file-dto');
exports.searchAllFile = () =>{

    return new Promise((resolve,reject) =>{
        const connection = getConnection();

        const results = FileRepository.searchAllFile(connection);

        connection.end();

        resolve(results) 
    })
    
}

exports.searchFilesByFileNum = (filenum) =>{
    return new Promise((resolve,reject) =>{
        const connection = getConnection();

        const results = FileRepository.searchFilesByFileNum(connection,filenum);

        connection.end();

        resolve(results)
    })
}

exports.uploadFile = (file) =>{
    return new Promise(async(resolve,reject)=>{
        const connection = getConnection();

        connection.beginTransaction();

        try {
            console.log("file",file)
            const result = await FileRepository.uploadFile(connection, file);

            const insertMenu = await FileRepository.searchFilesByFileNum(connection,result.insertId);
            const finalResults = [];
            const resultsLength = insertMenu.length;
            for (let index = 0; index < resultsLength; index++) {
                finalResults.push({...insertMenu[index]});
            }
            resolve(finalResults);
            connection.commit();            
        } catch (error) {
            connection.rollback();
            reject(error)
        }finally{
            connection.end();
        }
    })
}

exports.updateFile = (filenum,file) =>{
    return new Promise(async(resolve,reject)=>{

        const connection = getConnection();

        connection.beginTransaction();

        try {
            file.attachNum = filenum
            await FileRepository.updateFile(connection,file);
            const insertMenu = await FileRepository.searchFilesByFileNum(connection,filenum);
            const finalResults = [];
            const resultsLength = insertMenu.length;
            for (let index = 0; index < resultsLength; index++) {
                finalResults.push({...insertMenu[index]});
            }
            resolve(finalResults);
            connection.commit();            
        } catch (error) {
            connection.rollback();
            reject(error)
        }finally{
            connection.end();
        }
    })
}

exports.deleteFile = (filenum) =>{
    return new Promise(async(resolve,reject)=>{

        const connection = getConnection();

        connection.beginTransaction();

        try {
            const result = await FileRepository.deleteFile(connection,filenum);

            resolve(result);
            connection.commit();            
        } catch (error) {
            connection.rollback();
            reject(error)
        }finally{
            connection.end();
        }
    })
}