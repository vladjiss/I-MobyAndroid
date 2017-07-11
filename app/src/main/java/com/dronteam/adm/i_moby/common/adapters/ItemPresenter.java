package com.dronteam.adm.i_moby.common.adapters;

/**
 * Created by adm on 21.04.2017.
 */

public interface ItemPresenter<Model,View extends ItemView>{
    public void fill();
    public View getView();
    public Model getItem();
    int getItemId();
}