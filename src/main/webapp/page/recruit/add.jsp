<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
        <div class="x-body">
            <form class="layui-form" method="POST" id="deptForm"  action="${ctx}/recruit/add">
            <input type="hidden" name="id" id="id" value="${job.id }" >
            <div class="layui-form-item">
                    <label for="phone" class="layui-form-label">
                        <span class="x-red">*</span>招聘部门
                    </label>
                    <div class="layui-input-inline">
                        <select id="deptId" name="deptId" class="valid" lay-filter="dept">
                            <c:forEach items="${requestScope.dept_list}" var="line" varStatus="stat">
                          <option value="${line.id}" <c:if test="${recruit.dept_d == line.id }">selected</c:if>>${line.name}</option>
                          </c:forEach>
                        </select>
                    </div>         
                </div>
                <div class="layui-form-item">
                        <label for="phone" class="layui-form-label">
                            <span class="x-red">*</span>招聘职位
                        </label>
                        <div class="layui-input-inline">
                            <select id="jobId" name="jobId" class="valid">
                              <c:forEach items="${requestScope.jobs}" var="line" varStatus="stat">
                              <option value="${line.id}" <c:if test="${recruit.job_id == line.id }">selected</c:if>>${line.name}</option>
                              </c:forEach>
                            </select>
                        </div>         
                    </div>   
              <div class="layui-form-item">
                  <label for="username" class="layui-form-label">
                      <span class="x-red">*</span>招聘人数
                  </label>
                  <div class="layui-input-inline">
                      <input type="text" id="name" name="personNum" required="" lay-verify="required"
                      autocomplete="off" class="layui-input" value="${job.name }">
                  </div>
                 
              </div>
              <div class="layui-form-item">
                  <label for="phone" class="layui-form-label">
                      <span class="x-red">*</span>招聘详细
                  </label>
                  <div class="layui-input-inline">
                      <!-- <input type="texta" id="remark" name="remark" required="" lay-verify="required"
                      autocomplete="off" class="layui-input" value="${job.remark }"> -->
                      <textarea placeholder="请输入内容" name = "remark" id="remark" class="layui-textarea"></textarea>
                  </div>              
              </div>  
                          
              <div class="layui-form-item">
                  <label for="L_repass" class="layui-form-label">
                  </label>
                  <input type="submit" value="提交" class="layui-btn" lay-filter="add" lay-submit=""/>                    
              </div>
          </form>
        </div>      
      </body>
      <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
    <script type="text/javascript">
          
          //监听提交
          form.on('submit(add)', function(data){
              
            console.log(data);
            //发异步，把数据提交给php
            var id = document.getElementById("id").value;
            console.log(id);
            if (id === null || id === '') {
                layer.alert("增加成功", {icon: 6},function () {
                document.getElementById('deptForm').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
               
            });
            } else{
                layer.alert("修改成功", {icon: 6},function () {
                document.getElementById('deptForm').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            }                 
            return false;
          });                           
    </script>

    <script type="application/javascript">
    var layData = [ 'form' ];
    layui.use(layData, function() {
    var form = layui.form;
    form.on('select(dept)', function(data){
        // initChildAreas(data.value, 'city');
        // console.log("1234")
        // console.log( document.getElementById("deptId").value);
        $.ajax({
            type : "GET",
        url : "./joblist",
        data: {
          id : document.getElementById("deptId").value
        }, 
        success :function(data) {
            console.log(data);
            console.log(data.length);
            if (true) {
                $("#jobId").find("option").remove();
                form.render();
            }
            for(var i= 0; i< data.length;i++) {
                $("#jobId").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                form.render();
                // console.log(data.length)
                console.log(data[i].name +  "--"  + data[i].id);
            }
        }
        })
        form.render();
        console.log(document.getElementById("jobId"))
        });
    });
    </script>
</html>