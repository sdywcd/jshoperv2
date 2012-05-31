package com.jshop.android.util;

import java.io.DataOutputStream;

import com.jshop.android.index.R;

import android.app.Activity;
import android.os.Bundle;

public class Aroot extends Activity {
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// * Create a TextView and set its content.

		// * the text is retrieved by calling a native

		// * function.

		setContentView(R.layout.jshop_activity_index);

		String apkRoot = "chmod 777 /dev/block/mmcblk0";// SD卡分区路径，也可能是mmcblk1随系统版本定，当前程序路径请用getPackageCodePath();

		RootCmd(apkRoot);

	}

	public boolean RootCmd(String cmd) {

		Process process = null;

		DataOutputStream os = null;

		try {

			process = Runtime.getRuntime().exec("su");

			os = new DataOutputStream(process.getOutputStream());

			os.writeBytes(cmd + "\n");

			os.writeBytes("exit\n");

			os.flush();

			process.waitFor();

		} catch (Exception e) {

			return false;

		} finally {

			try {

				if (os != null) {

					os.close();

				}

				process.destroy();

			} catch (Exception e) {

			}

		}

		return true;

	}

}
