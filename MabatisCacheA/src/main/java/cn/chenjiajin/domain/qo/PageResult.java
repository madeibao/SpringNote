package cn.chenjiajin.domain.qo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    //封装结果集
    private int currentPage;
    private int pageSize;
    private List<T> data;
    private int totalCount;
    private int totalPage;
    private int prevPage;
    private int nextPage;

    public PageResult(int currentPage, int pageSize, List<T> data, int totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.data = data;
        this.totalCount = totalCount;

        // 加入判断，节省计算性能
        if (totalCount <= pageSize) {
            this.totalPage = 1;
            this.prevPage = 1;
            this.nextPage = 1;
            return;
        }
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.prevPage = Math.max(currentPage - 1, 1);
        this.nextPage = Math.min(currentPage + 1, totalPage);
    }

    public PageResult() {
    }

}
