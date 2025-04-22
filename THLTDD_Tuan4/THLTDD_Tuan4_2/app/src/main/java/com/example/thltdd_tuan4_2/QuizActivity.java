package com.example.thltdd_tuan4_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    TextView tvQuestion;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3, option4;
    Button btnNext;

    String[] questions = {
            "Nhà nước đầu tiên của người Việt cổ có tên là gì?",
            "Trận Bạch Đằng năm 938 là cuộc kháng chiến chống lại quân xâm lược nào?",
            "Ai là người viết bản “Tuyên ngôn Độc lập” cho Việt Nam năm 1945?",
            "Ai là Tổng Bí thư đầu tiên của Đảng Cộng sản Việt Nam?",
            "“Ta thà làm quỷ nước Nam còn hơn làm vương đất Bắc” là câu nói nổi tiếng của ai?",
            "Ai là người đã hi sinh để cứu vua Lê Lợi trong cuộc khởi nghĩa Lam Sơn?",
            "Nam quốc sơn hà Nam đế cư” là tuyên ngôn độc lập đầu tiên, do ai viết ra?",
            "Người anh hùng lấp lỗ châu mai trong chiến dịch Điện Biên Phủ là ai?",
            "Ai là người đã hy sinh khi dùng thân mình chèn bánh pháo trong chiến dịch Điện Biên Phủ?",
            "Ai là người đã dùng vai mình làm giá súng cho đồng đội bắn trong chiến dịch Điện Biên Phủ?"

    };

    String[][] options = {
            {"Văn Lang", "Âu Lạc", "Nam Việt", "Đại Cồ Việt"},
            {"Nguyên Mông", "Nam Hán", "Minh", "Tống"},
            {"Hồ Chí Minh", "Võ Nguyên Giáp", "Trường Chinh", "Phạm Văn Đồng"},
            {"Nguyễn Ái Quốc", "Lê Duẩn", "Trần Phú", "Phạm Văn Đồng"},
            {"Trần Bình Trọng", "Võ Nguyên Giáp", "Trường Chinh", "Lê Lai"},
            {"Nguyễn Trãi", "Lý Thường Kiệt", "Trần Nguyên Hãn", "Lê Lai"},
            {"Lê Lợi", "Lý Thường Kiệt", "Trần Hưng Đạo", "Lê Lai"},
            {"Phan Đình Giót", "Tô Vĩnh Diện", "Nguyễn Viết Xuân", "Trần Can"},
            {"Bế Văn Đàn", "Nguyễn Viết Xuân", "Phan Đình Giót", "Tô Vĩnh Diện"},
            {"Nguyễn Viết Xuân", "Bế Văn Đàn",  "Phan Đình Giót", "Tô Vĩnh Diện"}
    };

    String[] correctAnswers = {
            "Văn Lang", "Nam Hán", "Hồ Chí Minh", "Trần Phú", "Trần Bình Trọng"
            , "Lê Lai", "Lý Thường Kiệt", "Phan Đình Giót", "Tô Vĩnh Diện", "Bế Văn Đàn"
    };

    int currentQuestion = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion = findViewById(R.id.tvQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        btnNext = findViewById(R.id.btnNext);

        loadQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(QuizActivity.this, "Vui lòng chọn đáp án", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedOption = findViewById(selectedId);
                String answer = selectedOption.getText().toString();

                if (answer.equals(correctAnswers[currentQuestion])) {
                    score += 10;
                }

                currentQuestion++;

                if (currentQuestion < questions.length) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("SCORE", score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    void loadQuestion() {
        tvQuestion.setText(questions[currentQuestion]);
        option1.setText(options[currentQuestion][0]);
        option2.setText(options[currentQuestion][1]);
        option3.setText(options[currentQuestion][2]);
        option4.setText(options[currentQuestion][3]);
        radioGroup.clearCheck();
    }
}
