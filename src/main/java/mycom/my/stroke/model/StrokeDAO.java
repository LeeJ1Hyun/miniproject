package mycom.my.stroke.model;

import com.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 해당 DAO는 [1] 영법 추가만 있음
public class StrokeDAO {

    public int insertStroke(StrokeDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getConnection();

            String sql = "insert into Stroke(nn, price, nameOfstroke) values(Stroke_seq.nextval, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setDouble(1, dto.getPrice());
            ps.setString(2, dto.getNameOfstroke());

            int cnt = ps.executeUpdate();
            System.out.println("상품 등록 결과 cnt=" + cnt + ", 매개변수 dto=" + dto);
            return cnt;
        } finally {
            DBUtil.dbClose(ps, con);
        }
    } 
}

