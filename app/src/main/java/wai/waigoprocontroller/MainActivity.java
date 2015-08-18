package wai.waigoprocontroller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends Activity implements View.OnClickListener, Switch.OnCheckedChangeListener{
    Button triggerBtn,stopBtn,
            wideBtn,mediumBtn,narrowBtn,
            lowlightOnBtn,lowlightOffBtn,spotmeterOn,spotmeterOff;
    GoProAPI gopro;
    Spinner videoresolutionSpinner;
    Spinner videofpsSpinner;
    Switch modeSwitch;
    ArrayAdapter videoresolutionAdapter,videoFPSAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gopro = new GoProAPI();
        modeSwitch = (Switch) findViewById(R.id.Mode);
        modeSwitch.setOnCheckedChangeListener(this);
        stopBtn = (Button) findViewById(R.id.Stop);
        triggerBtn = (Button) findViewById(R.id.Trigger);
        triggerBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        videoresolutionSpinner = (Spinner) findViewById(R.id.videoresolution);
        ArrayAdapter videoresolutionAdapter = new ArrayAdapter(
                                                    this,
                                                    android.R.layout.simple_spinner_item,
                                                    VideoResolution.videoResolution.getAllLabel());
        videoresolutionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        videoresolutionSpinner.setAdapter(videoresolutionAdapter);
        videoresolutionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._4000p.toString());
                        break;
                    case 1:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._4000p_SuperView.toString());
                        break;
                    case 2:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._2700p.toString());
                        break;
                    case 3:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._2700p_SuperView.toString());
                        break;
                    case 4:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._2700p_4TO3.toString());
                        break;
                    case 5:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._1440p.toString());
                        break;
                    case 6:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._1080p_SuperView.toString());
                        break;
                    case 7:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._1080p.toString());
                        break;
                    case 8:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._960p.toString());
                        break;
                    case 9:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._720p_SuperView.toString());
                        break;
                    case 10:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._720p.toString());
                        break;
                    case 11:
                        gopro.APICall(AppConstant.setting +
                                VideoResolution.videoResolution._WVGA.toString());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        videofpsSpinner = (Spinner) findViewById(R.id.FPS);
        videofpsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                gopro.SetFPS(fps[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        wideBtn = (Button) findViewById(R.id.Wide);
        wideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gopro.APICall("setting/4/0");
            }
        });
        mediumBtn = (Button) findViewById(R.id.Medium);
        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gopro.APICall("setting/4/1");
            }
        });
        narrowBtn = (Button) findViewById(R.id.Narrow);
        narrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gopro.APICall("setting/4/2");
            }
        });
        lowlightOnBtn = (Button) findViewById(R.id.lowlightOn);
        lowlightOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gopro.APICall("setting/8/1");
            }
        });
        lowlightOffBtn = (Button) findViewById(R.id.lowlightOff);
        lowlightOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gopro.APICall("setting/8/0");
            }
        });
        spotmeterOn = (Button) findViewById(R.id.spotmeterOn);
        spotmeterOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gopro.APICall("setting/9/1");
            }
        });
        spotmeterOff = (Button) findViewById(R.id.spotmeterOff);
        spotmeterOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gopro.APICall("setting/9/0");
            }
        });
    }
    public void videoClicked(View view){
        gopro.APICall(AppConstant.command+"mode?p=0");
    }
    public void photoClicked(View view){
        gopro.APICall(AppConstant.command+"mode?p=1");
    }
    public void triggerClicked(View view){
        gopro.APICall(AppConstant.command+"shutter?p=1");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Trigger:
                gopro.APICall(AppConstant.command+"shutter?p=1");
                break;
            case R.id.Stop:
                gopro.APICall(AppConstant.command+"shutter?p=0");
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.Mode:
                if (buttonView.isChecked())
                {
                    /**
                     * true = Video
                     * false = Photo
                     */
                    Log.i("GOPRO","Video->Photo");
                    gopro.APICall(AppConstant.command+"mode?p=0");
                }
                else
                {
                    Log.i("GOPRO", "Video->Photo");
                    gopro.APICall(AppConstant.command+"mode?p=1");
                }
                break;
        }
    }
}
