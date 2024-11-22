package br.com.fiap.globaljava.groq;

import java.util.List;

public class IAResponse {

    private List<Choice> choices;

    public IAResponse() {
    }

    public IAResponse(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public static class Choice {
        private Message message;

        public Choice() {
        }

        public Choice(Message message) {
            this.message = message;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public static class Message {
            private String role;
            private String content;

            public Message() {
            }

            public Message(String role, String content) {
                this.role = role;
                this.content = content;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}