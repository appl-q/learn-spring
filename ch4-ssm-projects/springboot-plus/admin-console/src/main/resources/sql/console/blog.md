queryByCondition
===


    select 
    @pageTag(){
    t.*
    @}
    from cms_blog t
    where 1=1  
    @//数据权限，该sql语句功能点  
    and #function("blog.query")#
    
    
    

batchDelCmsBlogByIds
===

* 批量逻辑删除

    update cms_blog set del_flag = 1 where id in( #join(ids)#)
    
