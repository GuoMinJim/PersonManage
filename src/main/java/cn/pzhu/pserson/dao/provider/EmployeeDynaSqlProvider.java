package cn.pzhu.pserson.dao.provider;


import static cn.pzhu.pserson.util.Constants.EMPLOYEETABLE;

import cn.pzhu.pserson.domain.Employee;
import org.apache.ibatis.jdbc.SQL;

public class EmployeeDynaSqlProvider {
			// 动态插入
			public String insert_Employee(Employee job){

				return new SQL(){
					{
						INSERT_INTO(EMPLOYEETABLE);
						if(job.getName() != null ){
							VALUES("name", "#{name}");
						}
						if(job.getCardId()!=null){
							VALUES("card_id","#{card_id}");
						}
						if(job.getAddress()!=null){
							VALUES("address","#{address}");
						}
//						if(job.getPostCode()!=null){
//							VALUES("post_code","#{post_code}");
//						}
//						if(job.getTel()!=null){
//							VALUES("tel","#{tel}");
//						}
						if(job.getPhone()!=null){
							VALUES("phone","#{phone}");
						}
//						if(job.getQqNum()!=null){
//							VALUES("qq_nul","#{qq_num}");
//						}
						if(job.getEmail()!=null){
							VALUES("email","#{email}");
						}
						if(job.getSex()!=null){
							VALUES("sex","#{sex}");
						}
//						if(job.getParty()!=null){
//							VALUES("party","#{party}");
//						}
//						if(job.getBirthday()!=null){
//							VALUES("birthday","#{birthday}");
//						}
//						if(job.getRace()!=null){
//							VALUES("race","#{race}");
//						}
						if(job.getEducation()!=null){
							VALUES("education","#{education}");
						}
//						if(job.getSpeciality()!=null){
//							VALUES("speciality","#{speciality}");
//						}
//						if(job.getHobby()!=null){
//							VALUES("hobby","#{hobby}");
//						}
						if(job.getRemark()!=null){
							VALUES("remark","#{remark}");
						}
						if(job.getCreateDate()!=null){
							VALUES("createDate","#{createDate}");
						}
						if(job.getCreateDate()!=null){
							VALUES("dept_id","#{dept_id}");
						}
						if(job.getJobId()!=null){
							VALUES("job_id","#{job_id}");
						}
					}
				}.toString();
			}
			// 动态更新
			public String update_Employee(Employee job){

				return new SQL(){
					{
						UPDATE(EMPLOYEETABLE);
						if(job.getName() != null ){
							SET("name = #{name}");
						}
						if(job.getCardId()!=null){
							SET("card_id = #{card_id}");
						}
						if(job.getAddress()!=null){
							SET("address = #{address}");
						}
//						if(job.getPostCode()!=null){
//							SET("post_code = #{post_code}");
//						}
//						if(job.getTel()!=null){
//							SET("tel = #{tel}");
//						}
						if(job.getPhone()!=null){
							SET("phone = #{phone}");
						}
//						if(job.getQqNum()!=null){
//							SET("qq_nul = #{qq_num}");
//						}
						if(job.getEmail()!=null){
							SET("email = #{email}");
						}
						if(job.getSex()!=null){
							SET("sex = #{sex}");
						}
//						if(job.getParty()!=null){
//							SET("party = #{party}");
//						}
//						if(job.getBirthday()!=null){
//							SET("birthday = #{birthday}");
//						}
//						if(job.getRace()!=null){
//							SET("race = #{race}");
//						}
						if(job.getEducation()!=null){
							SET("education = #{education}");
						}
//						if(job.getSpeciality()!=null){
//							SET("speciality = #{speciality}");
//						}
//						if(job.getHobby()!=null){
//							SET("hobby = #{hobby}");
//						}
						if(job.getRemark()!=null){
							SET("remark = #{remark}");
						}
						if(job.getCreateDate()!=null){
							SET("createDate = #{createDate}");
						}
						if(job.getDeptId()!=null){
							SET("dept_id = #{dept_id}");
						}
						if(job.getJobId()!=null){
							SET("job_id = #{job_id}");
						}

						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
