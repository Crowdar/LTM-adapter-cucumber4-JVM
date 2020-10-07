package io.lippia.reporter.service;

import java.util.concurrent.atomic.AtomicInteger;

class CodeBlock implements Markup {
    private static final long serialVersionUID = -5532095355983830164L;
    private static final AtomicInteger id = new AtomicInteger(0);
    private String code;
    private CodeLanguage lang;

    CodeBlock() {
    }

    public void setCodeBlock(String code) {
        this.code = code;
    }

    public String getCodeBlock() {
        return this.code;
    }

    public void setCodeBlock(String code, CodeLanguage lang) {
        this.code = code;
        this.lang = lang;
    }

    @Override
    public String getMarkup() {
        if (this.lang == CodeLanguage.JSON) {
            int index = id.getAndIncrement();
            return "<div class='json-tree' id='code-block-json-" + index + "'></div><script>function jsonTreeCreate" + index + "() { document.getElementById('code-block-json-" + index + "').innerHTML = JSONTree.create(" + this.code + "); }jsonTreeCreate" + index + "();</script>";
        }
        String lhs = "<textarea disabled class='code-block'>";
        String rhs = "</textarea>";
        return lhs + this.code + rhs;
    }
}

