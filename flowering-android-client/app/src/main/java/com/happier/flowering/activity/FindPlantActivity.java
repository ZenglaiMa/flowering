package com.happier.flowering.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;
import com.github.ybq.android.spinkit.style.Wave;
import com.google.gson.Gson;
import com.happier.flowering.R;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FindPlantActivity extends AppCompatActivity {


    private static final int REQUEST_CODE_TAKE_PHOTO = 100;
    private static final int REQUEST_CODE_SELECT_GRAPH = 200;
    private String base64;
    private String imagePath;
    private ZLoadingDialog zLoadingDialog = new ZLoadingDialog(this);
    Gson gson = new Gson();
    private Uri photoUri;   //相机拍照返回图片路径
    private Intent intent;
    private LinearLayout ll_Album;
    private LinearLayout ll_takePhoto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findplant);
        ll_Album = findViewById(R.id.y_album);
        ll_takePhoto = findViewById(R.id.y_takePhoto);

        verifyStoragePermissions(this);
        ll_Album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_SELECT_GRAPH);
            }
        });

        ll_takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //去寻找是否已经有了相机的权限
                if (ContextCompat.checkSelfPermission(FindPlantActivity.this,
                        Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){

                    SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    String filename = timeStampFormat.format(new Date());
                    ContentValues values = new ContentValues(); //使用本地相册保存拍摄照片
                    values.put(MediaStore.Images.Media.TITLE, filename);
                    photoUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                    //Toast.makeText(MainActivity.this,"您申请了动态权限",Toast.LENGTH_SHORT).show();
                    //如果有了相机的权限有调用相机
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    startActivityForResult(intent, REQUEST_CODE_TAKE_PHOTO);

                }else{
                    //否则去请求相机权限
                    ActivityCompat.requestPermissions(FindPlantActivity.this,new String[]{Manifest.permission.CAMERA},100);

                }
            }
        });
    }

//动态获取SD卡权限
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };
    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TAKE_PHOTO && resultCode == RESULT_OK) {//拍照
            Cursor cursor = getContentResolver().query(photoUri, null, null, null, null);
            if (cursor.moveToFirst()) {
                imagePath = cursor.getString(cursor.getColumnIndex("_data"));
                intent  = new Intent(FindPlantActivity.this,LoadingActivity.class);
                intent.putExtra("path",imagePath);
                startActivity(intent);
            }
        } else if (requestCode == REQUEST_CODE_SELECT_GRAPH && resultCode == RESULT_OK) {//相册
            Uri uri = data.getData();
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor.moveToFirst()) {
               imagePath = cursor.getString(cursor.getColumnIndex("_data"));
                intent  = new Intent(FindPlantActivity.this,LoadingActivity.class);
                intent.putExtra("path",imagePath);
                startActivity(intent);
            }
        }
    }



    private int[] computeSize(File srcImg) {
        int[] size = new int[2];

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;

        BitmapFactory.decodeFile(srcImg.getAbsolutePath(), options);
        size[0] = options.outWidth;
        size[1] = options.outHeight;

        return size;
    }


    private Bitmap getBitmapFromUri(Uri uri) {
        try {
            // 读取uri所在的图片
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            return bitmap;
        } catch (Exception e) {
            Log.e("[Android]", e.getMessage());
            Log.e("[Android]", "目录为：" + uri);
            e.printStackTrace();
            return null;
        }
    }

    public static String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }




}


