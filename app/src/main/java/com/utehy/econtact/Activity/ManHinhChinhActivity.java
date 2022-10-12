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
        tinTucList.add(new TinTuc("1", "RỘN RÀNG KHÔNG KHÍ NGÀY NHẬP HỌC CỦA TÂN SINH VIÊN K20 TRƯỜNG ĐẠI HỌC SPKT HƯNG YÊN.", "\uD83D\uDCA2Sáng ngày 24/9/2022, Trường Đại học SPKT Hưng yên đã tổ chức đón tiếp và hướng dẫn các thủ tục nhập học cho gần 3000 Tân sinh viên K20 Đại học chính quy trúng tuyển 21 ngành đào tạo khóa tuyển sinh 2022 – 2026.\n" +
                "❣️Trong không khí đầy hứng khởi đón chờ một tương lai mới, ngay từ rất sớm các bậc phụ huynh và học sinh từ nhiều tỉnh thành khác nhau đã có mặt tại 3 cơ sở của nhà trường để làm thủ tục nhập học chính thức. \n" +
                "❣️Với sự chỉ đạo sát sao của Lãnh đạo trường, cùng sự chuẩn bị chu đáo của các đơn vị chức năng, Đoàn thanh niên, Hội sinh viên công tác tư vấn, hướng dẫn quy trình nhập học, chuyển khoản kinh phí nhập học, tiếp nhận, kiểm tra hồ sơ, giấy tờ, tư vấn và đăng ký chỗ ở nội, ngoại trú; hướng dẫn xem thời khóa biểu và lịch học... được thực hiện nhanh gọn, thuận lợi, để lại ấn tượng tốt đẹp cho sinh viên và các bậc phụ huynh.\n" +
                "❣️Sau khi nhập học thành công, Tân sinh viên chú ý thực hiện Tuần Sinh hoạt công dân  - Sinh viên đầu khóa đợt 1 từ 26/9 – 8/10/2022 tại 3 cơ sở của nhà trường: http://utehy.edu.vn/...\n" +
                "❣️Các bạn thí sinh nộp hồ sơ cho đợt tuyển bổ sung đừng lo lắng quá nhé, nhà trường sẽ xét duyệt và gửi giấy báo nhập học sớm cho các bạn. \n" +
                "\uD83C\uDFAFWelcome SKH! Trường Đại học SPKT Hưng yên luôn mở rộng cánh cửa chào đón các bạn.", "https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/307731263_5756491784382146_2228951229644069509_n.jpg?stp=dst-jpg_p526x395&_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_ohc=mf31aTyq7E0AX8cy209&_nc_ht=scontent.fhan5-11.fna&oh=00_AT_Ra7uHPnG0D4kE9S4TWjUjRx6XtVaueMx_Ur6DQuScMQ&oe=633B3444", "25/09/2022"));
        tinTucList.add(new TinTuc("2",
                "TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT HƯNG YÊN CÔNG BỐ ĐIỂM CHUẨN TRÚNG TUYỂN ĐHCQ NĂM 2022 ",
                "Hội đồng tuyển sinh Trường Đại học Sư phạm Kỹ thuật Hưng Yên đã công bố điểm chuẩn trúng tuyển theo các phương thức xét tuyển 21 ngành đào tạo trình độ đại học chính quy\n" +
                        "✨ Các bạn thí sinh có thể tra cứu kết quả trúng tuyển chính thức tại: http://www.utehy.edu.vn/#/search-tt\n" +
                        "\uD83D\uDCA5 Lưu ý, các bạn thí sinh trúng tuyển sẽ xác nhận nhập học từ ngày 18/09 đến 17h ngày 30/9/2022 trên hệ thống của Bộ GD&ĐT.\n" +
                        "️\uD83C\uDFAF Thí sinh xem chi tiết điểm chuẩn trúng tuyển các phương thức tại đây: http://utehy.edu.vn/...", "https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/305043705_5731572476874077_968844672128595925_n.jpg?stp=dst-jpg_p180x540&_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_ohc=PLwf8cDLFAIAX8x-qpT&tn=PsNnDRrq0_zpKisg&_nc_ht=scontent.fhan5-11.fna&oh=00_AT-TpEinObBFnopkv0Mmtstyikz2VZblokeTDAsv7TSCKg&oe=6339C8B8", "29/9/2022"));

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
                Log.e("TAG", "onResponse: " + response.toString());
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
        dialog.show();
    }

}
