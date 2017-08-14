# Introducing Phone and Tablet handle

see more:
- https://android-developers.googleblog.com/2011/07/new-tools-for-managing-screen-sizes.html
- https://developer.android.com/guide/practices/tablets-and-handsets.html


```
res/layout/main_activity.xml           # For phones
res/layout-sw600dp/main_activity.xml   # For tablets


res/layout/main_activity.xml           # For phones
res/layout-sw600dp/main_activity.xml   # For 7” tablets
res/layout-sw720dp/main_activity.xml   # For 10” tablets

res/layout/main_activity.xml          # Single-pane
res/layout-w600dp/main_activity.xml   # Multi-pane when enough width

res/layout/main_activity.xml                 # For phones
res/layout-sw600dp/main_activity.xml         # Tablets
res/layout-sw600dp-w720dp/main_activity.xml  # Large width

// finally
res/layout/main_activity.xml           # For phones
res/layout-xlarge/main_activity.xml    # For pre-3.2 tablets
res/layout-sw600dp/main_activity.xml   # For 3.2 and up tablets
```

