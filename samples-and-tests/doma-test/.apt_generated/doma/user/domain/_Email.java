package doma.user.domain;

/** */
@javax.annotation.Generated(value = { "Doma", "1.21.1" }, date = "2012-04-18T22:35:39.421+0900")
public final class _Email implements org.seasar.doma.jdbc.domain.DomainType<java.lang.String, doma.user.domain.Email> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.21.1");
    }

    private static final _Email singleton = new _Email();

    private _Email() {
    }

    @Override
    public doma.user.domain.Email newDomain(java.lang.String value) {
        return doma.user.domain.Email.of(value);
    }

    @Override
    public Class<doma.user.domain.Email> getDomainClass() {
        return doma.user.domain.Email.class;
    }

    @Override
    public org.seasar.doma.jdbc.domain.DomainWrapper<java.lang.String, doma.user.domain.Email> getWrapper(doma.user.domain.Email domain) {
        return new Wrapper(domain);
    }

    /**
     * @return the singleton
     */
    public static _Email getSingletonInternal() {
        return singleton;
    }

    private static class Wrapper extends org.seasar.doma.wrapper.StringWrapper implements org.seasar.doma.jdbc.domain.DomainWrapper<java.lang.String, doma.user.domain.Email> {

        private doma.user.domain.Email domain;

        private Wrapper(doma.user.domain.Email domain) {
            this.domain = domain;
        }

        @Override
        protected java.lang.String doGet() {
            if (domain == null) {
                return null;
            }
            return domain.getValue();
        }

        @Override
        protected void doSet(java.lang.String value) {
            domain = doma.user.domain.Email.of(value);
        }

        @Override
        public doma.user.domain.Email getDomain() {
            return domain;
        }
    }
}
