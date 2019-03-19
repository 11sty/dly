package com.dly.pojo;

public class Scan {
    private Integer scan_id;
    private Integer scan_goods_id;
    private Integer scan_time;
    private Integer scan_member_id;

    public Scan() {
    }

    public Integer getScan_id() {
        return scan_id;
    }

    public void setScan_id(Integer scan_id) {
        this.scan_id = scan_id;
    }

    public Integer getScan_goods_id() {
        return scan_goods_id;
    }

    public void setScan_goods_id(Integer scan_goods_id) {
        this.scan_goods_id = scan_goods_id;
    }

    public Integer getScan_time() {
        return scan_time;
    }

    public void setScan_time(Integer scan_time) {
        this.scan_time = scan_time;
    }

    public Integer getScan_member_id() {
        return scan_member_id;
    }

    public void setScan_member_id(Integer scan_member_id) {
        this.scan_member_id = scan_member_id;
    }

    @Override
    public String toString() {
        return "Scan{" +
                "scan_id=" + scan_id +
                ", scan_goods_id=" + scan_goods_id +
                ", scan_time=" + scan_time +
                ", scan_member_id=" + scan_member_id +
                '}';
    }
}
