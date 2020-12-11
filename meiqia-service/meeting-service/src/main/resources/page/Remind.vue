<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 用药提醒表
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-button type="primary" icon="el-icon-delete" class="handle-del mr10" @click="delAllSelection">批量删除</el-button>
                <el-input v-model="vo.keyWord" placeholder="关键字查询" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button type="primary" icon="el-icon-circle-plus-outline" @click="handleAdd">添加</el-button>
            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" header-cell-class-name="table-header"
                      @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="id" label="用药提醒主键ID"></el-table-column>
                <el-table-column prop="patientId" label="患者ID"></el-table-column>
                <el-table-column prop="meetingId" label="会诊ID"></el-table-column>
                <el-table-column prop="remindTime" label="提醒时间"></el-table-column>
                <el-table-column prop="remindText" label="提醒文本"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button type="text" icon="el-icon-delete" class="red" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination background layout="total, prev, pager, next" :current-page="currPage" :page-size="pageSize" :total="pageTotal"
                               @current-change="handlePageChange"></el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="患者ID">
                    <el-input v-model="form.patientId"></el-input>
                </el-form-item>
                <el-form-item label="会诊ID">
                    <el-input v-model="form.meetingId"></el-input>
                </el-form-item>
                <el-form-item label="提醒时间">
                    <el-input v-model="form.remindTime"></el-input>
                </el-form-item>
                <el-form-item label="提醒文本">
                    <el-input v-model="form.remindText"></el-input>
                </el-form-item>

            </el-form>
            <span slot="footer" class="dialog-footer">
				<el-button @click="editVisible = false">取 消</el-button>
				<el-button type="primary" @click="saveEdit">确 定</el-button>
			</span>
        </el-dialog>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: 'Remind',
        data() {
            return {
                vo: {
                    keyWord: '',
                },
                currPage: 1,
                pageSize: 5,
                pageTotal: 10,
                baseURL: 'http://127.0.0.1:8081',
                tableData: [],
                multipleSelection: [],
                editVisible: false,
                form: {},
            };
        },
        created() {
            this.getData();
        },
        methods: {
            // 获取 easy-mock 的模拟数据
            getData() {
                axios.post(this.baseURL + '/remind/search/' + this.currPage + '/' + this.pageSize, this.vo).then(res => {
                    this.tableData = res.data.body.rows;
                    this.pageTotal = res.data.body.total;
                })
            },
            // 触发搜索按钮
            handleSearch() {
                this.getData();
            },
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                })
                    .then(() => {
                        axios.delete(this.baseURL + '/remind/' + row.id).then(res => {
                            if (res.data.flag) {
                                this.getData();
                                this.$message.success(res.data.msg == null ? `操作成功` : res.data.msg);
                            } else {
                                this.$message.error(res.data.msg == null ? `操作失败` : res.data.msg);
                            }
                        })
                    })
                    .catch(() => {});
            },
            // 多选操作
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            delAllSelection() {
                if (this.multipleSelection.length == 0) {
                    this.$message.warn(`请选择要删除的数据`);
                    return;
                }
                let ids = [];
                this.multipleSelection.map(res => {
                    ids.push(res.id);
                });
                // 二次确认删除
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                })
                    .then(() => {
                        axios.post(this.baseURL + '/remind/delByIds', ids).then(res => {
                            if (res.data.flag) {
                                this.getData();
                                this.multipleSelection = [];
                                this.$message.success(res.data.msg == null ? `操作成功` : res.data.msg);
                            } else {
                                this.$message.error(res.data.msg == null ? `操作失败` : res.data.msg);
                            }
                        })
                    })
                    .catch(() => {});
            },
            // 添加操作
            handleAdd() {
                this.form = {};
                this.editVisible = true;
            },
            // 编辑操作
            handleEdit(index, row) {
                this.form = row;
                this.editVisible = true;
            },
            // 保存编辑
            saveEdit() {
                let result = {};
                if (this.form.id == null) {
                    result = axios.post(this.baseURL + '/remind', this.form);
                } else {
                    result = axios.put(this.baseURL + '/remind', this.form);
                }
                // 处理结果
                result.then(res => {
                    if (res.data.flag) {
                        this.$message.success(res.data.msg == null ? `操作成功` : res.data.msg);
                        this.editVisible = false;
                        this.getData();
                    } else {
                        this.$message.error(res.data.msg == null ? `操作失败` : res.data.msg);
                    }
                });

            },
            // 分页导航
            handlePageChange(val) {
                this.currPage = val;
                this.getData();
            }
        }
    };
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }

    .table {
        width: 100%;
        font-size: 14px;
    }

    .red {
        color: #ff0000;
    }

    .mr10 {
        margin-right: 10px;
    }

    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
</style>
