<template>
    <div class="user-login">
        <div class="user-login-bg"
             :style="{'background-image':`url(${backgroundImage})`}"></div>
        <div class="content-wrapper">
            <h2 class="slogan">
                欢迎使用 <br/> UMP 统一管理系统
            </h2>
            <div class="form-container">
                <h4 class="form-title">登录</h4>
                <el-form ref="loginForm" :model="user" :rules="rules"
                         label-width="0">
                    <div class="form-items">
                        <el-row class="form-item">
                            <el-col>
                                <el-form-item prop="username">
                                    <div class="form-line">
                                        <el-input placeholder="用户名"
                                                  v-model="user.username">
                                            <i slot="prefix"
                                               class="el-icon-edit-outline input-icon"></i>
                                        </el-input>
                                    </div>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row class="form-item">
                            <el-col>
                                <el-form-item prop="password">
                                    <div class="form-line">
                                        <el-input type="password"
                                                  placeholder="密码"
                                                  v-model="user.password">
                                            <i slot="prefix"
                                               class="el-icon-service input-icon"></i>
                                        </el-input>
                                    </div>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row class=form-item>
                            <el-col>
                                <el-form-item>
                                    <el-checkbox class="checkbox">记住账号
                                    </el-checkbox>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row class="form-item">
                            <el-button type="primary" class="submit-btn"
                                       size="small" @click="submitBtn">
                                登 录
                            </el-button>
                        </el-row>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapActions} from 'vuex';

    export default {
        name: "UserLogin",
        data() {
            return {
                backgroundImage: require('@/views/business/login/image/login.png'),
                user: {
                    username: 'admin',
                    password: '123456',
                },
                // 校验
                rules: {
                    username: [
                        {
                            required: true,
                            message: '用户名',
                            trigger: 'blur'
                        }
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            ...mapActions('portal/account', [
                'login'
            ]),
            submitBtn() {
                this.$refs['loginForm'].validate((valid) => {
                    if (valid) {
                        this.login({
                            vm: this,
                            userName: this.user.username,
                            password: this.user.password
                        }).then(() => {
                            this.$router.replace(this.$route.query.redirect || '/')
                        })
                    } else {
                        // 登录表单校验失败
                        this.$message.error('表单校验失败')
                    }
                });
            },
        },
    }
</script>

<style lang="scss" scoped>
    @import './style/login';
</style>