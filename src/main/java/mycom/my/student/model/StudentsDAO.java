package mycom.my.student.model;

import com.db.DBUtil;
import com.my.view.EditStudents;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.*;

//해당 DAO는 [1] 수강생 추가 (insert) : 완료
//           [2] 수강생 수정 (update, delete) : 수정 완료, 삭제 두가지 완료
//           [3] 수강생 조회 (select) : 이름으로 조회 완료, 전체 조회 완료
public class StudentsDAO {

    public int insertStudents(StudentsDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getConnection();

            String sql = "insert into Students(nn, name, teachername, stroke, No) values(Students_seq.nextval, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, dto.getName());
            ps.setString(2, dto.getTeachername());
            ps.setString(3, dto.getStroke());
            ps.setInt(4, dto.getNo());

            int cnt = ps.executeUpdate();
            System.out.println("회원가입 결과 cnt=" + cnt + ", 입력값 dto=" + dto);
            return cnt;
        } finally {
            DBUtil.dbClose(ps, con);
        }
    }

    public int updateStudents(StudentsDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getConnection();

            String sql = "update Students set teachername=?, stroke=?, No=? where name=?";
            ps = con.prepareStatement(sql);

            ps.setString(1, dto.getTeachername());
            ps.setString(2, dto.getStroke());
            ps.setInt(3, dto.getNo());
            ps.setString(4, dto.getName()); //이거 추가함
            
            int cnt = ps.executeUpdate();
            System.out.println("수정 결과 cnt=" + cnt + ", 입력값=" + dto);
            return cnt;
        } finally {
            DBUtil.dbClose(ps, con);
        }
    }

    public int deleteStudents(String name) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getConnection();

            String sql = "delete from Students where=name";
            ps = con.prepareStatement(sql);

            ps.setString(1, name);

            int cnt = ps.executeUpdate();
            System.out.println("상품 삭제 결과 cnt=" + cnt + ", 매개변수 name=" + name);
            return cnt;
        } finally {
            DBUtil.dbClose(ps, con);
        }
    }

    public int deleteStudents2(StudentsDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.getConnection();

            String sql = "delete from Students where name=?";
            ps = con.prepareStatement(sql);

            ps.setString(1, dto.getName());

            int cnt = ps.executeUpdate();
            System.out.println("상품 삭제 결과 cnt=" + cnt + ", 매개변수 dto=" + dto);
            return cnt;
        } finally {
            DBUtil.dbClose(ps, con);
        }
    }

    public StudentsDTO selectStudents(String name) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        StudentsDTO dto = new StudentsDTO();

        try {
            con = DBUtil.getConnection();

            String sql = "select * from Students where name=?";
            ps = con.prepareStatement(sql);

            ps.setString(1, name);

            rs = ps.executeQuery();
            if (rs.next()) {
                int nn = rs.getInt("nn");
                String teachername = rs.getString("teachername");
                String stroke = rs.getString("stroke");
                int No = rs.getInt("No");

                dto.setNn(nn);
                dto.setTeachername(teachername);
                dto.setStroke(stroke);
                dto.setNo(No);
                dto.setName(name);
            }

            System.out.println("이름으로 조회 결과 dto=" + dto + ", 매개변수 name=" + name);

            return dto;
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public List<StudentsDTO> selectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<StudentsDTO> list = new ArrayList<StudentsDTO>();

        try {
            con = DBUtil.getConnection();

            String sql = "select * from Students order by nn desc";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int nn = rs.getInt(1);
                String name = rs.getString(2);
                String teachername = rs.getString(3);
                String stroke = rs.getString(4);
                int No = rs.getInt(5);

                StudentsDTO dto = new StudentsDTO(nn, name, teachername, stroke, No);
                list.add(dto);
            }
            
            System.out.println("상품전체 조회 결과 list.size=" + list.size());
            return list;
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
    }
}
