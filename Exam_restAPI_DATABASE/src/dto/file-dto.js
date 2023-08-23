class FileDTO {
    attachNum;
    attachName;
    attachRename;
    deleteYN;
    fileSize;
    fileType;
    postNum;


    constructor(data) {
        this.attachNum=data.attachNum;
        this.attachName = data.attachName;
        this.attachRename = data.attachRename;
        this.deleteYN = data.deleteYN;
        this.fileSize = data.fileSize;
        this.fileType = data.fileType;
        this.postNum = data.postNum;
    }
}

module.exports = FileDTO;