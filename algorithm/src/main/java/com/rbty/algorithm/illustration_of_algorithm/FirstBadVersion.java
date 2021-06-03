package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 278. 第一个错误的版本
 * @date 2021/4/8 14:45
 */
public class FirstBadVersion {
    /**
     * @description: true,true,true,false,false
     */
    private final boolean[] versions;

    public FirstBadVersion(boolean[] versions) {
        this.versions = versions;
    }

    public boolean isBadVersion(int version){
        return !versions[version];
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = ((right - left) >> 1) + left;
            if (isBadVersion(mid-1)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        boolean[] versions = new boolean[]{true,true,true,false,false};
        FirstBadVersion firstBadVersion = new FirstBadVersion(versions);
        System.out.println(firstBadVersion.firstBadVersion(5));
    }
}
