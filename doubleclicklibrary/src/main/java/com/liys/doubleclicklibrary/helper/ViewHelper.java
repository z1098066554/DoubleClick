package com.liys.doubleclicklibrary.helper;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: liys
 * @CreateDate: 2019/8/22 10:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/22 10:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ViewHelper{

    /**
     * 获取所有子View
     * @param view
     * @return
     */
    public static List<View> getAllChildViews(View view) {
        List<View> allchildren = new ArrayList<View>();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View viewchild = viewGroup.getChildAt(i);
                allchildren.add(viewchild);
                //再次 调用本身（递归）
                allchildren.addAll(getAllChildViews(viewchild));
            }

            viewGroup.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
                @Override
                public void onChildViewAdded(View view, View view1) {
                    ViewDoubleHelper.hookChildViews(view);
                }

                @Override
                public void onChildViewRemoved(View view, View view1) {

                }
            }); //监听
        }
        return allchildren;
    }

}