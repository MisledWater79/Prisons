package com.misled.prisons.utils;

import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;
import com.misled.prisons.PrisonCore;

public class PluginValues {
    public static boolean cowsEnabled = true;
    public static final Vector3[] cowCords = {new Vector3(-10,213,0),new Vector3(10,213,0),new Vector3(0,213,0)};
    public static final Vector3 WARD_A_CORDS = new Vector3(0,214,0);
    public static final Vector3 WARD_B_CORDS = new Vector3(0,214,0);
    public static final Vector3 WARD_C_CORDS = new Vector3(0,214,0);
    public static final Vector3 WARD_D_CORDS = new Vector3(0,214,0);

    public Level getWorld(String name){
        return PrisonCore.getInstance().getServer().getLevelByName(name);
    }
}
