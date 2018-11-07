package com.wzm.api.util;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
public class Page {

    int start;      // 开始数据
    int count;      // 每一页的数量
    int total;      // 总共的数据量



    public int getStart() {
        return start;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }


    public void setStart(int start) {
        this.start = start;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    public Page(int start, int count) {
        super();
        this.start = start;
        this.count = count;
    }

    public boolean isHasPreviouse(){
        if(start==0)
            return false;
        return true;

    }
    public boolean isHasNext(){
        if(start==getLast())
            return false;
        return true;
    }

    public int getTotalPage(){
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count)
            totalPage = total /count;
            // 假设总数是51，不能够被5整除的，那么就有11页
        else
            totalPage = total / count + 1;

        if(0==totalPage)
            totalPage = 1;
        return totalPage;

    }

    public int getLast(){
        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是40
        if (0 == total % count)
            last = total - count;
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % count;

        last = last<0?0:last;
        return last;
    }





}