package com.example.skd.myapp.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by skd
 *
 * Activity栈,管理所有当前的Activity
 * 不可在此处使用具体的Activity
 *
 * 适合在BaseActivity中进行插入和移除activity操作
 */
public class AppManager {
    private static final String TAG = "AppManager";
    private Stack<Activity> activities;
    private static AppManager appManager;
    //记录所有当前存活在内存的activity对象
    private static ArrayList arrayList = new ArrayList();

    private AppManager() {
        activities = new Stack<Activity>();
    }

    public static AppManager getInstance() {
        if (appManager == null) {
            appManager = new AppManager();
        }
        return appManager;
    }

    public void addActivity(Activity activity) {
        activities.push(activity);
        recordActivity(activity);
    }

    public void exit() {
        try {
            for (Activity activity : activities) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    public Activity getCurrentActivity() {
        if (activities != null && activities.size() > 0) {
            return activities.peek();
        }
        return null;
    }

    public static boolean isMainThread() {
        long id = Looper.getMainLooper().getThread().getId();
        long currentThreadId = Thread.currentThread().getId();
        return (currentThreadId == id);
    }

    public void remove(Activity baseActivity) {
        if (baseActivity != null) {
            activities.remove(baseActivity);
        }
    }

    //记录当前活着的activity，方便测试
    private void recordActivity(Activity activity) {
        ArrayList list = new ArrayList();
        for (Object object : arrayList) {
            if (((WeakReference) object).get() == null) {
                list.add(object);
            }
        }
        if (list.size() > 0) {
            arrayList.removeAll(list);
        }
        WeakReference weakReference = new WeakReference(activity);
        arrayList.add(weakReference);
        Log.i(TAG, "当前所有Activity：");
        for (Object object : arrayList) {
            if (object != null && ((WeakReference) object).get() != null) {
                Log.i(TAG, ((WeakReference) object).get().toString());
            }
        }
    }


    /**
     * 跳到指定的activity
     *
     * @param distActivity
     */
    public void popToActivity(Activity distActivity) {
        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            if (activity == distActivity) {
                break;
            }
            activity.finish();
        }
    }



    /**
     * 跳到指定的activity.
     *
     * @param className
     */
    public final void popToActivity(Class className) {
        Activity activity = AppManager.getInstance().getActivityByClass(className);
        if (activity != null) {
            AppManager.getInstance().popToActivity(activity);
        }
    }


    /**
     * 跳到指定的activity
     *
     * @param distActivity
     */
    public void popToActivity(String distActivity) {
        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            if (activity.getClass().getName().equals(distActivity)) {
                break;
            }
            activity.finish();
        }
    }

    /**
     * 获取当前activity的上一个activity
     */
    public Activity getPreActivity() {
        if (activities.size() >= 2) {
            return activities.get(activities.size() - 2);
        } else {
            return null;
        }
    }

    public Activity getPreActivity(int index) {
        if (activities.size() >= index) {
            return activities.get(activities.size() - index);
        } else {
            return null;
        }
    }

    public Stack<Activity> getActivities() {
        return activities;
    }

    public Context getApplicationContext() {
        if (getCurrentActivity() != null) {
            return getCurrentActivity().getApplicationContext();
        }
        return null;
    }

    /**
     * 寻找最后一个某Activity的实例.
     * @param activityClass
     * @return
     */
    public final Activity getActivityByClass(Class activityClass) {
        if (activityClass == null) {
            return null;
        }
        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            if (activityClass.isInstance(activity)) {
                return activity;
            }
        }
        return null;
    }


    //
    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activities.lastElement();
        return activity;
    }



    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activities) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

}
