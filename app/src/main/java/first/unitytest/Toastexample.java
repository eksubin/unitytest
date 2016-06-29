package first.unitytest;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Set;

/**
 * Created by Robotics Lab on 6/27/2016.
 */
public class Toastexample {

    private BluetoothAdapter myBluetoot;
    private Set<BluetoothDevice> pairedDevices;

        private Context context;
        private static Toastexample instance;

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
            BluetoothAdapter myBluetooth = BluetoothAdapter.getDefaultAdapter();

            if(myBluetooth == null)
            {
                //Show a mensag. that the device has no bluetooth adapter
                Toast.makeText(this.context, "Bluetooth Device Not Available", Toast.LENGTH_LONG).show();

                //finish apk

            }
            else if(!myBluetooth.isEnabled())
            {
                Toast.makeText(this.context,"communication possible",Toast.LENGTH_LONG).show();
                //Ask to the user turn the bluetooth on
                Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                context.startActivity(turnBTon);
            }

        }

    }
