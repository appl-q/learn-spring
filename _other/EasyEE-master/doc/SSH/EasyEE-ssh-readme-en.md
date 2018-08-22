# EasyEE-SSH(JPA) Platform Development Manual

EasyEE is an open source JaveEE enterprise-class rapid development of the basic platform, provide a variety of technical options options, support Spring Boot, Hibernate, MyBatis, Struts, Shiro and other core framework.

It integrates the widely used framework of JaveEE domain and EasyUI front-end framework. It provides the back-end rights management system, security management framework and common development components based on user, role and permission scheme. Provides infrastructure and specifications for enterprise-level project development.

[EasyEE Auto](https://github.com/ushelp/EasyEE-Auto 'EasyEE Auto') automated code generator is provided.


## SSH Framework

- **Struts 2.5+**
- **Hibernate 5+(JPA)**
- **Spring 4+**
- **Shiro 2+**
- EasyCommonDAO
- EasyShiro 
- EasyFilter
- EasyUI 1.4+
- EasyUIEx 2.2+


- **Struts2.5 Notice:**
Struts provides enhanced security access model`Strict Method Invocation (Strict DMI, SMI)` after 2.5 , if you want to call a method by wildcards or DMI must be configured to allow in `struts_default.xml` method name:

 ```XML
<!-- Allowed Methods for Strict DMI -->
<global-allowed-methods>execute,input,back,cancel,browse,save,delete,list,index,move,update,getAllPermissionsId,changePwd,regex:(list.*),regex:(all.*)</global-allowed-methods>
```


## EasyEE Auto

EasyEE Automated code generator。

[EasyEE Auto](https://github.com/ushelp/EasyEE-Auto 'EasyEE Auto') 




## Framework Manual

1. Project structure 

2. Quick Development Manual 

3. Other configuration instructions




##  Project structure 
```JS
EasySSH 
    + src/main/java 
        + cn.easyproject.easyee.ssh 
            + base (Base Common Package)
                + action 
                    + BaseAction.java(All Action extends BaseAction)
                + dao
                    + CommonDAO.java 
                    + impl
                        + CommonDAOSprintImpl.java 
                + service
                    + BaseService.java (All Service extends BaseService)
                + util 
                    + ... (PageBean, EasyCriteria, Encryption, Utils....)
            + sys (RBAC Package)
                + action, entity, service, util, shiro, criteria... 
            + hr  (Demo Module Package)
                + action, entity, service, criteria...
    + src/main/resource
        + i18n
            + messages.properties (i18n)
            + messages_zh_CN.properties (i18n)
        + spring
            + ApplicationContext_bean.xml (Spring Bean scanner)
            + ApplicationContext_dao.xml (Spring DAO)
            + ApplicationContext_shiro.xml (Spring Shiro)
            + ApplicationContext.xml (Spring Core configuration)
        + struts 
            + struts_default.xml (Struts2 default parent package)
            + struts_dispatcher.xml (Struts2 dispatcher)
            + struts_sys.xml (RBAC)
        + db.properties (jdbc info) 
        + easyFilter.properties (EasyFilter Web request filter)
        + ehcache.xml (ehcache )
        + log4j.properties (Log4J)
        + log4j2.xml (Log4J2)
        + struts.xml (Struts2 include)
        + struts.properties (Struts2 properties)
    + src/test/java 
    + src/test/resource 
    + WebRoot
        + doc
        + jsp 
            + echarts (ECharts demo)
            + error 
                + notFound.jsp (404 error)
                + permissionDenied.jsp (no permission)
                + serverError.jsp (500 error)
            + VerifyCode.jsp （CAPTCHA JSP）
        + locklogin
            + admin.jsp (EasyShiro LockLogin Management)
        + script (project module js, with WEB-INF/content)
            + main
                + sys (RBAC)
                + main.js (main.jsp)
            + login.js (login.jsp) 
        + staticresources
            + easyee 
                + json (easyssh json: theme, icon)
                + easyee-ssh.main.js (easyssh core js)
                + jquery.cookie.js 
            + easyui (EasyUI )
            + easyuiex (EasyUIEx)
            + echarts (EChars)
            + error (JSP Error Page)
            + images
            + style 
                + easyee.main.css (easyssh golbal css)
        + WEB-INF
            + content (project page)
                + dialog (EasyUI Dialog)
                    + sys (RBAC)
                    + hr (Demo module)
                + main (EasyUI Core page)
                    + sys (RBAC page)
                    + hr (Demo Page)
                    + main.jsp (EasySSH Main Page)
                + login.jsp 
            + lib 
            + web.xml
```


## Quick Development Manual 

1. **Create new moudle package**
   
 cn.easyproject.easyssh.`yourmodule`
 cn.easyproject.easyssh.yourmodule.`entity`
 cn.easyproject.easyssh.yourmodule.`service`
 cn.easyproject.easyssh.yourmodule.`action`
 cn.easyproject.easyssh.yourmodule.`criteria`
 
2. **Create POJO in entity package(Annotaion or XML)**

  ```JAVA
  @Entity
  @Table(name = "Dept")
  public class Dept implements java.io.Serializable {
 		//...
  }
  ```

3. **Create Service in service package**

 - Interface, Use `@Transactional` to declare transaction
 
     ```JAVA
	@Transactional
	public interface DeptService {
		public void save(Dept dept);
	
		public void delete(Serializable deptno);
	
		public void update(Dept dept);
	
		@Transactional(readOnly=true)
		public Dept get(Integer deptno);
	
		@SuppressWarnings("rawtypes")
		@Transactional(readOnly=true)
		public void findByPage(PageBean pageBean, DeptCriteria deptCriteria);
	
		@Transactional(readOnly=true)
		public int findMaxPage(int rowPerPage);
		
		@Transactional(readOnly=true)
		public List<Dept> findAll();
	}
     ```
 
 - Implements in `service.impl`
 
    - extends BaseService
    
    - direct invoke commonDAO method
    
    - use @Service
 
    ```JAVA
       /**
        * extends BaseService
        * direct invoke commonDAO method
        *  
        * @author easyproject.cn
        * @version 1.0
        *
        */
       @Service("deptService")
		public class DeptServiceImpl extends BaseService implements DeptService {
		
			@Override
			public void save(Dept dept) {
				commonDAO.persist(dept);
			}
		
			@Override
			public void delete(Serializable deptno) {
				commonDAO.updateByJpql("delete from Dept where deptno=?",deptno);
			}
		
			@Override
			public void update(Dept dept) {
				commonDAO.merge(dept);
			}
		
			@Override
			public Dept get(Integer deptno) {
				return commonDAO.find(Dept.class, deptno);
			}
		
			@SuppressWarnings("rawtypes")
			@Override
			public void findByPage(PageBean pageBean, DeptCriteria deptCriteria) {
				pageBean.setEntityName("Dept dept");
				pageBean.setSelect("select dept");
				
				// Pagination
				commonDAO.findByPage(pageBean,deptCriteria);
			}
		
			@Override
			public int findMaxPage(int rowPerPage) {
				return commonDAO.findMaxPage("select count(*) from Dept", rowPerPage);
			}
		
			@SuppressWarnings("unchecked")
			@Override
			public List<Dept> findAll() {
				return commonDAO.find("from Dept");
			}
		
		}
    ``` 

4. **Create Action Controller**

 ```JAVA
   /**
    * Must extends BaseAction
    * 
    * BaseAction includes:
    * - request, application Servlet API
    * - JSON parameters
    * - Init JSON data method（setJsonMap，setJsonMsgMap，setJsonPaginationMap(PageBean, Object...)）
    * - EasyUI Pagination parameter
    * - JSON constant: result="json" 
    *
    */
 @ParentPackage("easyssh-default")
 @Namespace("/Dept")
 public class DeptAction extends BaseAction {
 
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
 	
 	// variable name equals @Service("deptService"), need setter method
 	private DeptService deptService;
 	
 	private Dept dept;
 	private DeptCriteria deptCriteria;
 	
 	/**
 	 * Goto page
 	 * @return
 	 */
 	@Action(value="page",results={
 			@Result(location="/WEB-INF/content/main/hr/Dept.jsp")
 	})
 	public String page(){
 		return SUCCESS;
 	}
 	/**
 	 * CRUD
 	 * @return
 	 */
 	@Action("save")
 	public String save(){
 		// Save
 		try {
 			deptService.save(dept);
 			
 			// success message
 			msg = getText("msg.saveSuccess");
 
 			// if need update page data, goto last page
 //			super.page = deptService.findMaxPage(rows);
 		} catch (Exception e) {
 			e.printStackTrace();
 			msg = getText("msg.saveFail");
 			statusCode=StatusCode.ERROR; //默认为OK
 		}
 		
 		/*
 		 * Ajax response info
 		 * {
 		 * statusCode: status code, 
 		 * msg: message,
 		 * callback: callback function,
 		 * locationUrl: go to location
 		 * }
 		 */
  		// JSON out, include Message
    //	super.setJsonMsgMap();
  		// update datagrid info
 		super.setJsonMsgMap("rowData", dept);
 		
 		// return JSON data
 		return JSON;
 	}
 	
 	/**
 	 * Pagination
 	 * @return
 	 */
 	@SuppressWarnings("rawtypes")
 	@Action("list")
 	public String list(){
 		PageBean pb = super.getPageBean(); // get PageBean
 		deptService.findByPage(pb,deptCriteria);
 		super.setJsonPaginationMap(pb);
 		return JSON;
 	}
 
 	@Action("delete")
 	public String delete(){
 		try {
 			deptService.delete(dept.getDeptno());
 		} catch (Exception e) {
 			e.printStackTrace();
 			statusCode=StatusCode.ERROR;
 		}
 		super.setJsonMsgMap();
 		return JSON;
 	}
 	@Action("update")
 	public String update(){
 		try {
 			deptService.update(dept);
 			msg=getText("msg.updateSuccess");
 		} catch (Exception e) {
 			e.printStackTrace();
 			msg=getText("msg.updateFail");
 			statusCode=StatusCode.ERROR;
 		}
 		setJsonMsgMap();
 		return JSON;
 	}
 
 	public Dept getDept() {
 		return dept;
 	}
 
 	public void setDept(Dept dept) {
 		this.dept = dept;
 	}
 
 	public void setDeptService(DeptService deptService) {
 		this.deptService = deptService;
 	}
 
 	public DeptCriteria getDeptCriteria() {
 		return deptCriteria;
 	}
 
 	public void setDeptCriteria(DeptCriteria deptCriteria) {
 		this.deptCriteria = deptCriteria;
 	}
 }
 ```

5. **Page**

   - Create folder：
   
      - `webapp/WEB-INF/content/main/yourmodule`（EasyUI page）
       
      - `webapp/WEB-INF/content/dialog/yourmodule`(EasyUI Dialog page)
      
   - Develop Page
      - EasyEE use `EasyUI Tabs` of `href` include page,. 
      
      > EasyUI Two Dynamic Tabs difference between dynamic loading:
      > 
      > **-Use content (iframe frame) the introduction page:**
      >     content : '<iframe scrolling="auto" frameborder="0" src="'+ url + '" style="width:100%;height:100%;"></iframe>';
      >  Exist as a separate window, the page content independent, non-interfering with the current page
      >  Need to introduce independent JS and CSS resources needed
      >  Pop-up content is within the window
      > 
      > **-Use href methods:**
      >     href : url,
      >  A piece of content is loaded, the introduction of the contents of the current page and merge
      >  Need to introduce JS and CSS resource page has introduced
      >  Reference page can not have a body, or the contents of the internal loads of grammar JS file execution
      >  Html rendering prompt resolution displays
      >  To prevent inter-page DOM element, naming conflicts of JS (DOM unique name should be the same prefix, JS using namespaces)
      
      -To prevent unique prefix naming conflicts between pages DOM elements, you should use unified DOM element for each page
      - In order to prevent inter-page JavaScript variable naming conflicts should be defined only operating namespace for each page, all registration functions into the namespace
      - Recommended default development is structured as follows:
      ```JSP
        <%-- 1. Page Datagrid initialization related JS --%>
        
        <script type="text/javascript">
        // To avoid naming conflicts, define a unique operating namespace for each page
        // All functions registered into the namespace
        var sysRole = {};
        $(function() {
        	/*
        	 * datagrid init
        	 */
        	// ...

        	/*
        	 * datagrid CRUD
        	 */
        		
        	/*
        	 * datagird search
        	 */
        	
        });
        </script>
        
        <%-- 2. content, don't need Body --%>
        <!--  ... -->
        
        <%-- grid contextmenu --%>
        <!--  ... -->
        
        <%-- 3. Dialog Page--%>
        <!--  ... -->
      ```

6. **And configure access permissions**
   
   1. User Admin to Add `Menu Permission`(`/Dept/page`, click on the menu to access the action requested JSP views)
   
   2.  User Admin to Add `Operation Permission`(CRUD Permission, Show Controller Permission)
   
   3. Assign `permissions and menu` operations for user
 


## Other configuration instructions

### 1. EasySSH Ajax Response

- EasySSH Ajax Response JSON:

   ```JSON
  {
    statusCode: status code,  
    msg: message,
    callback: callback function,
    locationUrl: goto location,
    //... other data
  }
   ```

- BaseAction out JSON method：

   ```JAVA
   // you can define JSON root data 
   setJsonRoot(Object);
   // JSON include your Object
   setJsonMap(Object...)
   // JSON include your Object and EasySSH Ajax response
   setJsonMsgMap(Object...)
   // JSON include your Object, Pagination data and EasySSH Ajax response
   setJsonPaginationMap(PageBean, Object...)
   ```
  

### 2. BaseAction 

  - Servlet API(request, application )
  - JSON result constant： ` final String JSON = "json";`
  - JSON parameter(pagination, Ajax response)
  - JSON response method(`setJsonRoot`, `setJsonMap`, `setJsonMsgMap`, `setJsonPaginationMap`)
  - reloadPermissions(): refreshing the user's current permission after to modify permissions
  - utils
   
  
### 3.  EasyCommonDAO

[EasyCommonDAO](https://github.com/ushelp/EasyCommonDAO 'EasyCommonDAO') provides a common persistence layer operation class, encapsulates a variety of daily operation methods, including pageBean and EasyCriteria-based paging and query condition processing components.

### PageBean pagination

- Example

   ```JAVA
   PageBean pb = new PageBean();

	// FROM Clause; optional
	// **If use EclipseLink is required!**
	pb.setSelect(" select new com.company.ssh.entity.Account(ac.accountid, ac.qxname) ");
	// FROM Clause Entity Name; rquired
	pb.setEntityName("Account ac"); 
	// Page Number; optional; default is 1
	pb.setPageNo(1); 
	// Rows per page; optional; default is 10
	pb.setRowsPerPage(4);
	// WHERE Clause; optional; default is ''
	pb.setCondition(" and ac.accountid>2");
	// Append where clause condition; optional; default is ''
	// pb.addCondition(" and name='A'");
	// SortName; optional; default is ''
	pb.setSort("ac.accountid");
	// SortOrder; optional; default is 'asc'
	pb.setSortOrder("desc");
	// Other sorting methods; optional; default is ''
	pb.setLastSort(",time desc");
	
	// Execute pagination quries
	commonDAO.findByPage(pb); 
	
	// Pagination data
	System.out.println(pb.getData());
	System.out.println(pb.getPageNo());
	System.out.println(pb.getRowsPerPage());
	System.out.println(pb.getRowsCount());
	System.out.println(pb.getPageTotal());
   ```

- Example2

   ```JAVA
   // Immediate use this query
	// data sql
	pb.setQuery("select ac from Account ac where ac.accountid>=10 and ac.accountid<1000");
	// total sql
	pb.setCountSQL("select count(1) from Account ac where ac.accountid>=10 and ac.accountid<1000"); 
	// Page Number; optional; default is 1
	pb.setPageNo(1); 
	// Rows per page; optional; default is 10
	pb.setRowsPerPage(4);
	
	// Execute pagination quries
	commonDAO.findByPage(pb); 
   
   // Pagination data...
   ```


#### EasyCriteria criteria queries

1. New your EasyCriteria class, must extends EasyCriteria implements Serializable

2. Write your condition by getCondition()

3. Find by EasyCriteria

- Example
    
    ```JAVA
    public class SysUserCriteria extends EasyCriteria implements java.io.Serializable {
       // 1. Criteria field
       private String name;
       private String realName;
       private Integer status; // 0 is ON; 1 is OFF; 2 is REMOVED
    
       // 2. Constructor
       public SysUserCriteria() {
       }
    
       public SysUserCriteria(String name, String realName, Integer status) {
           super();
           this.name = name;
           this.realName = realName;
           this.status = status;
       }
    
       // 3. Condition genertator abstract method implements
       public String getCondition() {
           values.clear(); // **Must clear old values**
    
           StringBuffer condition = new StringBuffer();
           if (StringUtils.isNotNullAndEmpty(this.getName())) {
               condition.append(" and name like ?");
               values.add("%" + this.getName() + "%");
           }
           if (StringUtils.isNotNullAndEmpty(this.getRealName())) {
               condition.append(" and realName like ?");
               values.add("%" + this.getRealName() + "%");
           }
           if (StringUtils.isNotNullAndEmpty(this.getStatus())) {
               condition.append(" and status=?");
               values.add(this.getStatus());
           }
           return condition.toString();
       }
    
       // 4. Setters&amp;Getters...
    
    }
    ```

- Usage

    ```JAVA
    PageBean pageBean = new PageBean();
    pageBean.setEntityName("SysUser users");
    pageBean.setSelect("select users");
    
    // EasyCriteria
    SysUserCriteria usersCriteria =new SysUserCriteria();
    usersCriteria.setName("A");
    usersCriteria.setStatus(0);
    
    // Find by EasyCriteria
    commonDAO.findByPage(pageBean, usersCriteria);
    ```


### 5. Rights Profile

- **Access Configuration**

  1. Adding menu rights and operation permissions
  
  2. The menu for the role permissions and rights are allocated
 
  3. Assign roles to users
 
- **Show Controller(e.g. WEB-INF/content/jsp/module/dept.jsp)**

  1. Show Permissions Configuration Permissions action in operation

  2. Include `siro-tags` taglig, You will need to display the contents of the definition of control in `shiro:hasPermission` within,` name` specified must have permission to display the name of the action
  
    ```JSP
   <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
 
 	<shiro:hasPermission name="deptDeleteShow">
 	   	<div onclick="$('#deptDataGrid').edatagrid('destroyRow')" data-options="iconCls:'icon-remove'">Delete</div>
 	</shiro:hasPermission>
   ```

  3. Assign rights for users


### 6. Add-ons:

- **EasyShiro** ([API](http://easyproject.cn/easyshiro/en/index.jsp#readme "EasShiro API"))

 EasyShiro based Shiro is a security extension components. Database rights management and Web URL authorization RBAC (Role Based Access Control) Web-based permission model provides universal support. EasyShiro simplifies security integration, and verification code, auto login, login is locked, an error message management, interceptors, Ajax, etc. in response to a more powerful and comprehensive feature support, only a simple configuration can be.


- **EasyFilter Jave Web Request paramtere filter** ([API](http://easyproject.cn/easyfilter/zh-cn/index.jsp#readme "EasyFilter API"))
 
  EasyFilter is a Jave Web content filtering request replacement of a component, supports the use of properties or xml configuration file to customize the filter configuration, the user can request the following information to filter replacement:

  1. Replace special characters (such as: & lt ;, & gt; special tags, scripts, etc.)
  
  2. Illegal keyword substitution (such as: network situation does not allow China's special keywords)
  
  3. SQL-injection filter (eg:%, *, or, delete, and so on SQL special keyword)

  **In `easyFilter.xml` has predefined default alternative arrangement.**

- **EasyCommons** ([API](http://easyproject.cn/easycommons/zh-cn/index.jsp#readme "EasyCommons API"))

  - EasyCommons-imageutils
  
    Provide a picture compression, picture address extraction, image watermarking tools. 

  - EasyCommons-objectutils
  
    Provided instead of Java Properties object properties file operations component.

  - EasyCommons-propertiesutils
  
    Provided (`FieldExpression`) field expression object attribute extraction based on object attribute filter, waited in vain for the object attribute is set Obejct object manipulation components.
 
       
### 7. EasyUIEx

[EasyUIEx API](http://easyproject.cn/easyuiex "EasyUIEx API") use jQuery EasyUI framework for the development of extensible plug-ins, mainly for common functions EasyUI framework encapsulates and expansion EasyUI can greatly increase the ease of use, simplify operational complexity, and provide additional functionality.

Use during project development jQuery EasyUI + EasyUIEx architecture can greatly simplify the complexity EasyUI framework uses, especially in the various aspects of CRUD data grid, he made a high degree of packaging.

In the project, a priority search EasyUIEx API functions can be done to achieve a multiplier effect.
  

## Demo

[Demo Online](http://www.easyproject.cn/easyee 'Demo')

Username: `demo`

Password: `111111`

![Demo](../images/easyee.png)


## End

[Demo - English](http://www.easyproject.cn/easyee/en/index.jsp#demo 'Demo - English]')


[The official home page](http://www.easyproject.cn/easyee/en/index.jsp 'The official home page')

[Comments](http://www.easyproject.cn/easyee/en/index.jsp#donation 'Comments')

If you have more comments, suggestions or ideas, please contact me.

Contact, Feedback, Custom, Train Email：<inthinkcolor@gmail.com>

[http://www.easyproject.cn](http://www.easyproject.cn "EasyProject Home")



We believe that the contribution of each bit by bit, will be driven to produce more and better free and open source products a big step.

**Thank you donation to support the server running and encourage more community members.**

[![PayPal](http://www.easyproject.cn/images/paypaldonation5.jpg)](https://www.paypal.me/easyproject/10 "Make payments with PayPal - it's fast, free and secure!")



## END
### [The official home page](http://www.easyproject.cn/easyuiex/en/index.jsp 'The official home page')

[Comments](http://www.easyproject.cn/easyuiex/en/index.jsp#donation 'Comments')

If you have more comments, suggestions or ideas, please contact me.


### [官方主页](http://www.easyproject.cn/easyuiex/zh-cn/index.jsp '官方主页')

[留言评论](http://www.easyproject.cn/easyuiex/zh-cn/index.jsp#donation '留言评论')

如果您有更好意见，建议或想法，请联系我。




Email：<inthinkcolor@gmail.com>

[http://www.easyproject.cn](http://www.easyproject.cn "EasyProject Home")





We believe that the contribution of each bit by bit, will be driven to produce more and better free and open source products a big step.

**Thank you donation to support the server running and encourage more community members.**

[![PayPal](http://www.easyproject.cn/images/paypaldonation5.jpg)](https://www.paypal.me/easyproject/10 "Make payments with PayPal - it's fast, free and secure!")

