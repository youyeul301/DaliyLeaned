exports.searchAllFile= () =>{
    
    return 'select * from attachment';
}

exports.searchFilesByFileNum = () =>{
    return `select * from attachment where attach_num = ?`
}

exports.uploadFile = ()=>{
    return `insert
                into attachment
            (attach_name,attach_rename,delete_yn,filesize,file_type,post_num)
            values
            (?,?,?,?,?,?)
            `
}

exports.updateFile = ()=>{
    return `UPDATE
                attachment
            set attach_name = ? ,attach_rename = ? ,delete_yn = ? ,filesize = ? ,file_type = ?,post_num = ?
            where attach_num = ?
            `
}

exports.deleteFile = ()=>{
    return `DELETE 
                FROM attachment 
            WHERE attach_num = ?
            `
}
