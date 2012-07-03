package doma.user.domain;

/** */
@javax.annotation.Generated(value = { "Doma", "1.21.1" }, date = "2012-04-18T22:35:39.437+0900")
public final class _Password implements org.seasar.doma.jdbc.domain.DomainType<java.lang.String, doma.user.domain.Password> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.21.1");
    }

    private static final _Password singleton = new _Password();

    private _Password() {
    }

    @Override
    public doma.user.domain.Password newDomain(java.lang.String value) {
        return new doma.user.domain.Password(value);
    }

    @Override
    public Class<doma.user.domain.Password> getDomainClass() {
        return doma.user.domain.Password.class;
    }

    @Override
    public org.seasar.doma.jdbc.domain.DomainWrapper<java.lang.String, doma.user.domain.Password> getWrapper(doma.user.domain.Password domain) {
        return new Wrapper(domain);
    }

    /**
     * @return the singleton
     */
    public static _Password getSingletonInternal() {
        return singleton;
    }

    private static class Wrapper extends org.seasar.doma.wrapper.StringWrapper implements org.seasar.doma.jdbc.domain.DomainWrapper<java.lang.String, doma.user.domain.Password> {

        private doma.user.domain.Password domain;

        private Wrapper(doma.user.domain.Password domain) {
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
            domain = new doma.user.domain.Password(value);
        }

        @Override
        public doma.user.domain.Password getDomain() {
            return domain;
        }
    }
}
