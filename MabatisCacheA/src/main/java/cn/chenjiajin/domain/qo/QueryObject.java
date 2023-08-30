package cn.chenjiajin.domain.qo;


import lombok.Data;

@Data
public class QueryObject {
    private int currentPage = 1;
    private int pageSize = 3;

    public int getStart() {
        return (currentPage - 1) * pageSize;
    }




}
