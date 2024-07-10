const base = {
    get() {
        return {
            url : "http://localhost:8080/scholarship/",
            name: "scholarship",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "奖学金系统"
        } 
    }
}
export default base
