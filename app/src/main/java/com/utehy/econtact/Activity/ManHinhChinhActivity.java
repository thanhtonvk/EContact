package com.utehy.econtact.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.Adapter.ThongbaoAdapter;
import com.utehy.econtact.Adapter.TinTucAdater;
import com.utehy.econtact.Api.ApiService;
import com.utehy.econtact.Models.TinTuc;
import com.utehy.econtact.R;
import com.utehy.econtact.Service.NotificationService;
import com.utehy.econtact.Tools.Common;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManHinhChinhActivity extends AppCompatActivity {

    TextView tvTenPhuHuynh, tvHoTen, tvXemChiTiet;
    ImageView imgAvatar, imgAvatarSV;
    ImageButton btnNoti;
    TextView tvNumNoti;
    RecyclerView rcvTinTuc;
    List<TinTuc> tinTucList;
    TinTucAdater tinTucAdater;
    Button btnHocTap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }
        initView();
        loadThongTin();
        onClick();
        loadTinTuc();

    }

    private void initView() {
        tvTenPhuHuynh = findViewById(R.id.tv_name);
        tvHoTen = findViewById(R.id.tv_ho_ten);
        tvXemChiTiet = findViewById(R.id.tv_xem_chi_tiet);
        imgAvatar = findViewById(R.id.img_avatar);
        imgAvatarSV = findViewById(R.id.img_avatar_sv);
        btnNoti = findViewById(R.id.img_btn_noti);
        tvNumNoti = findViewById(R.id.tv_num_of_noti);
        rcvTinTuc = findViewById(R.id.rcv_tin_tuc);
        tinTucList = new ArrayList<>();
        btnHocTap = findViewById(R.id.btn_hoc_tap);
    }

    private void onClick() {
        tvXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HoSoActivity.class));
            }
        });
        btnHocTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HocTapActivity.class));
            }
        });
        findViewById(R.id.btn_diem_rl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DiemRenLuyenActivity.class));
            }
        });
        findViewById(R.id.img_btn_noti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPopUpThongBao();
            }
        });
        findViewById(R.id.btn_lien_he).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LienHeActivity.class));
            }
        });
        findViewById(R.id.btn_cai_dat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CatDatActivity.class));
            }
        });
        findViewById(R.id.btn_hoc_phi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HocPhiActivity.class));
            }
        });
    }


    private void loadTinTuc() {
        tinTucList.add(new TinTuc("1", "R???N R??NG KH??NG KH?? NG??Y NH???P H???C C???A T??N SINH VI??N K20 TR?????NG ?????I H???C SPKT H??NG Y??N.", "\uD83D\uDCA2S??ng ng??y 24/9/2022, Tr?????ng ?????i h???c SPKT H??ng y??n ???? t??? ch???c ????n ti???p v?? h?????ng d???n c??c th??? t???c nh???p h???c cho g???n 3000 T??n sinh vi??n K20 ?????i h???c ch??nh quy tr??ng tuy???n 21 ng??nh ????o t???o kh??a tuy???n sinh 2022 ??? 2026.\n" +
                "??????Trong kh??ng kh?? ?????y h???ng kh???i ????n ch??? m???t t????ng lai m???i, ngay t??? r???t s???m c??c b???c ph??? huynh v?? h???c sinh t??? nhi???u t???nh th??nh kh??c nhau ???? c?? m???t t???i 3 c?? s??? c???a nh?? tr?????ng ????? l??m th??? t???c nh???p h???c ch??nh th???c. \n" +
                "??????V???i s??? ch??? ?????o s??t sao c???a L??nh ?????o tr?????ng, c??ng s??? chu???n b??? chu ????o c???a c??c ????n v??? ch???c n??ng, ??o??n thanh ni??n, H???i sinh vi??n c??ng t??c t?? v???n, h?????ng d???n quy tr??nh nh???p h???c, chuy???n kho???n kinh ph?? nh???p h???c, ti???p nh???n, ki???m tra h??? s??, gi???y t???, t?? v???n v?? ????ng k?? ch??? ??? n???i, ngo???i tr??; h?????ng d???n xem th???i kh??a bi???u v?? l???ch h???c... ???????c th???c hi???n nhanh g???n, thu???n l???i, ????? l???i ???n t?????ng t???t ?????p cho sinh vi??n v?? c??c b???c ph??? huynh.\n" +
                "??????Sau khi nh???p h???c th??nh c??ng, T??n sinh vi??n ch?? ?? th???c hi???n Tu???n Sinh ho???t c??ng d??n  - Sinh vi??n ?????u kh??a ?????t 1 t??? 26/9 ??? 8/10/2022 t???i 3 c?? s??? c???a nh?? tr?????ng: http://utehy.edu.vn/...\n" +
                "??????C??c b???n th?? sinh n???p h??? s?? cho ?????t tuy???n b??? sung ?????ng lo l???ng qu?? nh??, nh?? tr?????ng s??? x??t duy???t v?? g???i gi???y b??o nh???p h???c s???m cho c??c b???n. \n" +
                "\uD83C\uDFAFWelcome SKH! Tr?????ng ?????i h???c SPKT H??ng y??n lu??n m??? r???ng c??nh c???a ch??o ????n c??c b???n.", "https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/307731263_5756491784382146_2228951229644069509_n.jpg?stp=dst-jpg_p526x395&_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_ohc=mf31aTyq7E0AX8cy209&_nc_ht=scontent.fhan5-11.fna&oh=00_AT_Ra7uHPnG0D4kE9S4TWjUjRx6XtVaueMx_Ur6DQuScMQ&oe=633B3444", "25/09/2022"));
        tinTucList.add(new TinTuc("2",
                "TR?????NG ?????I H???C S?? PH???M K??? THU???T H??NG Y??N C??NG B??? ??I???M CHU???N TR??NG TUY???N ??HCQ N??M 2022 ",
                "H???i ?????ng tuy???n sinh Tr?????ng ?????i h???c S?? ph???m K??? thu???t H??ng Y??n ???? c??ng b??? ??i???m chu???n tr??ng tuy???n theo c??c ph????ng th???c x??t tuy???n 21 ng??nh ????o t???o tr??nh ????? ?????i h???c ch??nh quy\n" +
                        "??? C??c b???n th?? sinh c?? th??? tra c???u k???t qu??? tr??ng tuy???n ch??nh th???c t???i: http://www.utehy.edu.vn/#/search-tt\n" +
                        "\uD83D\uDCA5 L??u ??, c??c b???n th?? sinh tr??ng tuy???n s??? x??c nh???n nh???p h???c t??? ng??y 18/09 ?????n 17h ng??y 30/9/2022 tr??n h??? th???ng c???a B??? GD&??T.\n" +
                        "???\uD83C\uDFAF Th?? sinh xem chi ti???t ??i???m chu???n tr??ng tuy???n c??c ph????ng th???c t???i ????y: http://utehy.edu.vn/...", "https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/305043705_5731572476874077_968844672128595925_n.jpg?stp=dst-jpg_p180x540&_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_ohc=PLwf8cDLFAIAX8x-qpT&tn=PsNnDRrq0_zpKisg&_nc_ht=scontent.fhan5-11.fna&oh=00_AT-TpEinObBFnopkv0Mmtstyikz2VZblokeTDAsv7TSCKg&oe=6339C8B8", "29/9/2022"));

        tinTucAdater = new TinTucAdater(this, tinTucList);
        rcvTinTuc.setAdapter(tinTucAdater);
    }

    private void loadThongTin() {
        tvTenPhuHuynh.setText(Common.LOGIN_USER.get("full_name").toString());
        Map<String, Object> jsonParams = new ArrayMap<>();
        Map<String, String> method = new HashMap<>();
        method.put("Method", "GET");
        jsonParams.put("Method", method);
        jsonParams.put("Url", "/api/subject-score/get-student-by-family");
        jsonParams.put("Module", "TEACHER");
        jsonParams.put("ContentType", "application/json");
        jsonParams.put("AcceptType", "application/json");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());
        ApiService.api.executeAdapter(body).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                Log.e("TAG", "onResponse: " + response);
                if (response.isSuccessful()) {
                    Map<String, Object> result = response.body();
                    List<Map<String, Object>> data = (List<Map<String, Object>>) result.get("data");
                    if (data.size() > 0) {
                        tvHoTen.setText(data.get(0).get("student_name").toString());
                        Common.STUDENT_BY_FAMILY = data.get(0);
                        NotificationService.className = Common.STUDENT_BY_FAMILY.get("class_id").toString();
                        startService(new Intent(getApplicationContext(), NotificationService.class));

                    }

                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    List<Map<String, Object>> thongBaos = new ArrayList<>();

    private void setPopUpThongBao() {
        Dialog dialog = new Dialog(ManHinhChinhActivity.this);
        dialog.setContentView(R.layout.dialog_thong_bao);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Button btnClose = dialog.findViewById(R.id.btn_huy);
        RecyclerView rcvThongBao = dialog.findViewById(R.id.rcv_thongbao);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        Map<String, Object> jsonParams = new ArrayMap<>();
        Map<String, String> method = new HashMap<>();
        method.put("Method", "POST");
        jsonParams.put("Method", method);
        jsonParams.put("Url", "/api/notification2/get-my-notification2");
        jsonParams.put("Module", "TEACHER");
        String data = "{\"page\":1,\"pageSize\":10}";
        jsonParams.put("Data", data);
        jsonParams.put("ContentType", "application/json");
        jsonParams.put("AcceptType", "application/json");

        Log.e("TAG", "loadDiem: " + jsonParams.toString());
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());
        ApiService.api.executeAdapter(body).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    thongBaos = (List<Map<String, Object>>) response.body().get("data");
                    ThongbaoAdapter adapter = new ThongbaoAdapter(thongBaos);
                    rcvThongBao.setAdapter(adapter);
                }
                Log.e("TAG", "onResponse: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
        dialog.show();
    }

}
