const sql = require('../database/file-query')

exports.searchAllFile = (connection)=>{

    return new Promise((resolve, reject) =>{

        connection.query(sql.searchAllFile(), (err,result)=>{
            if(err){
                reject(err)
            }

            resolve(result)
        })
    })    
}

exports.searchFilesByFileNum = (connection,fileNum)=>{
    return new Promise((resolve,reject) =>{
        connection.query(sql.searchFilesByFileNum(),[fileNum],(err,result) =>{
            if(err){
                reject(err)
            }

            resolve(result)
        })
    })
}

exports.uploadFile = (connection,file) =>{
    return new Promise((resolve,reject)=>{
        connection.query(sql.uploadFile(),
                        [
                            file.attachName,
                            file.attachRename,
                            file.deleteYN,
                            file.fileSize,
                            file.fileType,
                            file.postNum
                        ],
                        (err,result) =>{
            if(err){
                reject(err)
            }
            resolve(result);
        })
    })
}

exports.updateFile = (connection,file) =>{
    return new Promise((resolve,reject)=>{
        connection.query(sql.updateFile(),
                        [
                            file.attachName,
                            file.attachRename,
                            file.deleteYN,
                            file.fileSize,
                            file.fileType,
                            file.postNum,
                            file.attachNum
                        ],
                        (err,result) =>{
            if(err){
                reject(err)
            }
            resolve(result);
        })
    })
}

exports.deleteFile = (connection,fileNum) =>{
    return new Promise((resolve,reject)=>{
        connection.query(sql.deleteFile(),
                        [
                            fileNum
                        ],
                        (err,result) =>{
            if(err){
                reject(err)
            }
            resolve(result);
        })
    })
}