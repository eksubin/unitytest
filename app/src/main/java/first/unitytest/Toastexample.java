package first.unitytest;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.widget.Toast;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Robotics Lab on 6/27/2016.
 */
public class Toastexample {

    private BluetoothAdapter myBluetoot;
    private Set<BluetoothDevice> pairedDevices;

    //private ProgressDialog progress;
    // BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    Thread workerThread;
    byte[] readBuffer;
    volatile boolean stopWorker;
    String address;
    InputStream mmInputStream;
    byte[] packetBytes;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    //TextView textView;
    // Button button;
    // GraphView ecg_graph;
    BluetoothDevice mmDevice;
    OutputStream mmOutputStream;
    int bytesAvailable;
    // LineGraphSeries<DataPointInterface> series;
    int x=0;
    Scanner myscanner;
    boolean start_loop = true;
    BluetoothAdapter myBluetooth;

    ////////////// data string
    String snaptext;
    Paint paint;
    private BluetoothDevice positive;
        private Context context;
        private static Toastexample instance;
    private boolean ConnectSuccess = false;

    public Toastexample() {
            this.instance = this;
        }

        public static Toastexample instance() {
            if(instance == null) {
                instance = new Toastexample();
            }
            return instance;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        public void showMessage(String message) {
           Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show();
           myBluetooth = BluetoothAdapter.getDefaultAdapter();

            if(myBluetooth == null)
            {
                //Show a mensag. that the device has no bluetooth adapter
                Toast.makeText(this.context, "Bluetooth Device Not Available", Toast.LENGTH_LONG).show();

                //finish apk

            }
            else if(!myBluetooth.isEnabled())
            {
                Toast.makeText(this.context,"communication possible",Toast.LENGTH_LONG).show();
                Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                context.startActivity(turnBTon);

            }

        }

    public void startthread()
    {
        new Thread(new Runnable() {
            public void run() {


                }

        }).start();
    }

    ////////////////////////////////// extr stuffs to be added
    //trying to implement thread for establishing communincation

    //Thread mythread = new Thread(runnable);


}



