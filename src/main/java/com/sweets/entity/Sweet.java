package com.sweets.entity;

public class Sweet extends Entity {
    private String name;
    private Long wrapperWeight;
    private Long fillingWeight;
    private String sweetFilling;
    private String sweetWrapper;

    public Sweet(Builder builder) {
       // super(builder.id);
        this.name = builder.name;
        this.wrapperWeight = builder.wrapperWeight;
        this.fillingWeight = builder.fillingWeight;
        this.sweetFilling = builder.sweetFilling;
        this.sweetWrapper = builder.sweetWrapper;
    }

    public Sweet(Long id, String name, Long wrapperWeight, Long fillingWeight, String sweetFilling, String sweetWrapper) {
        super(id);
        this.name = name;
        this.wrapperWeight = wrapperWeight;
        this.fillingWeight = fillingWeight;
        this.sweetFilling = sweetFilling;
        this.sweetWrapper = sweetWrapper;
    }

    public Sweet() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String type;
        private Long wrapperWeight;
        private Long fillingWeight;
        private String sweetFilling;
        private String sweetWrapper;

        public Builder() {
        }

        public Builder(Long id, String name, Long wrapperWeight,
                       Long fillingWeight, String sweetFilling, String sweetWrapper) {
            this.id = id;
            this.name = name;
            this.wrapperWeight = wrapperWeight;
            this.fillingWeight = fillingWeight;
            this.sweetFilling = sweetFilling;
            this.sweetWrapper = sweetWrapper;
        }


        public Sweet build() {
            return new Sweet(this);
        }


       /* public Builder setId(Long id) {
            this.id = id;
            return this;
        }*/

        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder setWrapperWeight(Long wrapperWeight) {
            this.wrapperWeight = wrapperWeight;
            return this;
        }

        public Builder setFillingWeight(Long fillingWeight) {
            this.fillingWeight = fillingWeight;
            return this;
        }

        public Builder setSweetFilling(String sweetFilling) {
            this.sweetFilling = sweetFilling;
            return this;
        }

        public Builder setSweetWrapper(String sweetWrapper) {
            this.sweetWrapper = sweetWrapper;
            return this;
        }
    }


    public Long getId() {
        return id;
    }

    public Sweet setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sweet setName(String name) {
        this.name = name;
        return this;
    }


    public Long getWrapperWeight() {
        return wrapperWeight;
    }

    public Sweet setWrapperWeight(Long wrapperWeight) {
        this.wrapperWeight = wrapperWeight;
        return this;
    }

    public Long getFillingWeight() {
        return fillingWeight;
    }

    public Sweet setFillingWeight(Long fillingWeight) {
        this.fillingWeight = fillingWeight;
        return this;
    }

    public String getSweetFilling() {
        return sweetFilling;
    }

    public Sweet setSweetFilling(String sweetFilling) {
        this.sweetFilling = sweetFilling;
        return this;
    }

    public String getSweetWrapper() {
        return sweetWrapper;
    }

    public Sweet setSweetWrapper(String sweetWrapper) {
        this.sweetWrapper = sweetWrapper;
        return this;
    }


    @Override
    public String toString() {
        return "Sweet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wrapperWeight=" + wrapperWeight +
                ", fillingWeight=" + fillingWeight +
                ", sweetFilling='" + sweetFilling + '\'' +
                ", sweetWrapper='" + sweetWrapper + '\'' +
                '}';
    }
}
