package com.advanced.client.render;

import com.advanced.client.util.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class ShaderManager {

    private int programId = -1;
    private int vertexShaderId = -1;
    private int fragmentShaderId = -1;

    public boolean createProgram(String vertexSource, String fragmentSource) {
        vertexShaderId = compileShader(GL20.GL_VERTEX_SHADER, vertexSource);
        fragmentShaderId = compileShader(GL20.GL_FRAGMENT_SHADER, fragmentSource);

        if (vertexShaderId == -1 || fragmentShaderId == -1) {
            return false;
        }

        programId = GL20.glCreateProgram();
        GL20.glAttachShader(programId, vertexShaderId);
        GL20.glAttachShader(programId, fragmentShaderId);
        GL20.glLinkProgram(programId);

        if (GL20.glGetProgrami(programId, GL20.GL_LINK_STATUS) == GL11.GL_FALSE) {
            Logger.error("Shader link error: " + GL20.glGetProgramInfoLog(programId, 1024));
            return false;
        }

        return true;
    }

    private int compileShader(int type, String source) {
        int id = GL20.glCreateShader(type);
        GL20.glShaderSource(id, source);
        GL20.glCompileShader(id);
        if (GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            Logger.error("Shader compile error: " + GL20.glGetShaderInfoLog(id, 1024));
            return -1;
        }
        return id;
    }

    public void use() {
        if (programId != -1) GL20.glUseProgram(programId);
    }

    public void stop() {
        GL20.glUseProgram(0);
    }

    public void setUniform1i(String name, int value) {
        GL20.glUniform1i(GL20.glGetUniformLocation(programId, name), value);
    }

    public void setUniform1f(String name, float value) {
        GL20.glUniform1f(GL20.glGetUniformLocation(programId, name), value);
    }

    public void setUniform2f(String name, float x, float y) {
        GL20.glUniform2f(GL20.glGetUniformLocation(programId, name), x, y);
    }

    public void delete() {
        stop();
        if (vertexShaderId != -1) GL20.glDeleteShader(vertexShaderId);
        if (fragmentShaderId != -1) GL20.glDeleteShader(fragmentShaderId);
        if (programId != -1) GL20.glDeleteProgram(programId);
    }
}
