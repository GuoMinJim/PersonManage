package cn.pzhu.pserson.dao.provider;


import static cn.pzhu.pserson.util.Constants.DOCUMENTTABLE;

import cn.pzhu.pserson.domain.Document;
import org.apache.ibatis.jdbc.SQL;

public class DocumentDynaSqlProvider {
	
	// 动态插入
		public String insert(Document dept){
			
			return new SQL(){
				{
					INSERT_INTO(DOCUMENTTABLE);
					if(dept.getTitle() != null ){
						VALUES("title", "#{title}");
					}
					if(dept.getRemark() != null ){
						VALUES("remark", "#{remark}");
					}
					if(dept.getCreateDate() != null ){
						VALUES("create_date", "#{create_date}");
					}
					if(dept.getUserId() != null ){
						VALUES("user_id", "#{user_id}");
					}
					if(dept.getFilename() != null ){
						VALUES("filename", "#{filename}");
					}
				}
			}.toString();
		}	
		// 动态更新
		public String update(Document dept){
			
			return new SQL(){
				{
					UPDATE(DOCUMENTTABLE);
					if(dept.getTitle() != null){
						SET(" title = #{title} ");
					}
				
					if(dept.getRemark() != null){
						SET(" remark = #{remark} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
