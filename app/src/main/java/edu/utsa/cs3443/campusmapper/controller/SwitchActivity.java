package edu.utsa.cs3443.campusmapper.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class SwitchActivity implements View.OnClickListener{
    private Context context;
    private Class to_activity;
    private String[] transfer_data;


    public SwitchActivity(Context context, Class to_activity, String[] transfer_data) {
        this.context = context;
        this.to_activity = to_activity;
        this.transfer_data = transfer_data;
    }

    public void setData(String[] data) {
        transfer_data = data;
    }

    public String[] getData() {
        return transfer_data;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, to_activity);
        intent.putExtra("data", transfer_data);
        context.startActivity(intent);
    }
}
