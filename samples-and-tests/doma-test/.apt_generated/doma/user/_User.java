package doma.user;

/** */
@javax.annotation.Generated(value = { "Doma", "1.21.1" }, date = "2012-04-18T22:35:39.515+0900")
public final class _User extends org.seasar.doma.jdbc.entity.AbstractEntityType<doma.user.User> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.21.1");
    }

    private static final _User __singleton = new _User();

    private final org.seasar.doma.jdbc.id.BuiltinSequenceIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinSequenceIdGenerator();
    {
        __idGenerator.setQualifiedSequenceName("UserSeq");
        __idGenerator.setInitialValue(1);
        __idGenerator.setAllocationSize(1);
        __idGenerator.initialize();
    }

    /** the email */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, doma.user.User, java.lang.String, doma.user.domain.Email> email = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, doma.user.User, java.lang.String, doma.user.domain.Email>(doma.user.User.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, doma.user.domain._Email.getSingletonInternal(), "email", "email", true, true);

    /** the fullname */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, doma.user.User, java.lang.String, java.lang.Object> fullname = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, doma.user.User, java.lang.String, java.lang.Object>(doma.user.User.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, null, "fullname", "fullname", true, true);

    /** the id */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, doma.user.User, java.lang.Integer, java.lang.Object> id = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, doma.user.User, java.lang.Integer, java.lang.Object>(doma.user.User.class, java.lang.Integer.class, org.seasar.doma.wrapper.IntegerWrapper.class, null, null, "id", "id", __idGenerator);

    /** the isAdmin */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, doma.user.User, java.lang.Boolean, java.lang.Object> isAdmin = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, doma.user.User, java.lang.Boolean, java.lang.Object>(doma.user.User.class, java.lang.Boolean.class, org.seasar.doma.wrapper.BooleanWrapper.class, null, null, "isAdmin", "isAdmin", true, true);

    /** the password */
    public final org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, doma.user.User, java.lang.String, doma.user.domain.Password> password = new org.seasar.doma.jdbc.entity.BasicPropertyType<java.lang.Object, doma.user.User, java.lang.String, doma.user.domain.Password>(doma.user.User.class, java.lang.String.class, org.seasar.doma.wrapper.StringWrapper.class, null, doma.user.domain._Password.getSingletonInternal(), "password", "password", true, true);

    private final org.seasar.doma.jdbc.entity.NullEntityListener __listener;

    private final org.seasar.doma.jdbc.entity.NamingType __namingType;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final String __qualifiedTableName;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>> __entityPropertyTypeMap;

    private _User() {
        __listener = new org.seasar.doma.jdbc.entity.NullEntityListener();
        __namingType = org.seasar.doma.jdbc.entity.NamingType.NONE;
        __name = "User";
        __catalogName = "";
        __schemaName = "";
        __tableName = "User";
        __qualifiedTableName = "User";
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>> __idList = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>> __list = new java.util.ArrayList<org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>>(5);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>> __map = new java.util.HashMap<String, org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>>(5);
        __list.add(email);
        __map.put("email", email);
        __list.add(fullname);
        __map.put("fullname", fullname);
        __idList.add(id);
        __list.add(id);
        __map.put("id", id);
        __list.add(isAdmin);
        __map.put("isAdmin", isAdmin);
        __list.add(password);
        __map.put("password", password);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return __tableName;
    }

    @Override
    public String getQualifiedTableName() {
        return __qualifiedTableName;
    }

    @Override
    public void preInsert(doma.user.User entity, org.seasar.doma.jdbc.entity.PreInsertContext context) {
        __listener.preInsert(entity, context);
    }

    @Override
    public void preUpdate(doma.user.User entity, org.seasar.doma.jdbc.entity.PreUpdateContext context) {
        __listener.preUpdate(entity, context);
    }

    @Override
    public void preDelete(doma.user.User entity, org.seasar.doma.jdbc.entity.PreDeleteContext context) {
        __listener.preDelete(entity, context);
    }

    @Override
    public void postInsert(doma.user.User entity, org.seasar.doma.jdbc.entity.PostInsertContext context) {
        __listener.postInsert(entity, context);
    }

    @Override
    public void postUpdate(doma.user.User entity, org.seasar.doma.jdbc.entity.PostUpdateContext context) {
        __listener.postUpdate(entity, context);
    }

    @Override
    public void postDelete(doma.user.User entity, org.seasar.doma.jdbc.entity.PostDeleteContext context) {
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<doma.user.User, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, doma.user.User, ?, ?> getGeneratedIdPropertyType() {
        return id;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, doma.user.User, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public doma.user.User newEntity() {
        return new doma.user.User();
    }

    @Override
    public Class<doma.user.User> getEntityClass() {
        return doma.user.User.class;
    }

    @Override
    public doma.user.User getOriginalStates(doma.user.User __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(doma.user.User __entity) {
    }

    /**
     * @return the singleton
     */
    public static _User getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _User newInstance() {
        return new _User();
    }

}
