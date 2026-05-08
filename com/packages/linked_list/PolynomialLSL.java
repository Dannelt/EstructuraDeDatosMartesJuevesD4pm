package com.packages.linked_list;

public class PolynomialLSL 
{
    public NodePolynomial head;
    private boolean ordered;

    public PolynomialLSL()
    {
        head = null;
        ordered = false;
    }

    public NodePolynomial getHead() 
    {
        return head;
    }

    public void setHead(NodePolynomial head) 
    {
        this.head = head;
    }

    public boolean getOrdered()
    {
        return ordered;
    }

    public void setOrdered(boolean ordered)
    {
        this.ordered = ordered;
    }

    public void clearPolynomial()
    {
        head = null;
        ordered = false;
    }

    public int countNodesPolynomial()
    {
        NodePolynomial p = head;
        int i = 0;

        while (p != null) {
            i++;
            p = p.link;
        }

        return i;
    }

    public NodePolynomial findTerm(int exponent)
    {
        NodePolynomial p = head;
        NodePolynomial q = null;
        boolean sw = false;

        while (p != null && !sw) {
            if (p.exponent == exponent) {
                sw = true;
                q = p;
            } else {
                p = p.link;
            }
        }

        return q;
    }

    public boolean addTerm(int coefficient, int exponent)
    {
        boolean sw = false;

        if (findTerm(exponent) == null) {
            if (ordered) {
                insertOrdered(coefficient, exponent);
            } else {
                createEndPolynomial(coefficient, exponent);
            }
            sw = true;
        }

        return sw;
    }

    public void createEndPolynomial(int coefficient, int exponent)
    {
        NodePolynomial p = new NodePolynomial();
        p.coefficient = coefficient;
        p.exponent = exponent;
        p.link = null;

        if (head == null) {
            head = p;
        } else {
            NodePolynomial q = head;

            while (q.link != null) {
                q = q.link;
            }

            q.link = p;
        }
    }

    public void insertOrdered(int coefficient, int exponent)
    {
        NodePolynomial p = new NodePolynomial();
        p.coefficient = coefficient;
        p.exponent = exponent;
        p.link = null;

        if (head == null || exponent > head.exponent) {
            p.link = head;
            head = p;
        } else {
            NodePolynomial q = head;
            NodePolynomial r = head.link;
            boolean sw = false;

            while (r != null && !sw) {
                if (exponent > r.exponent) {
                    sw = true;
                } else {
                    q = r;
                    r = r.link;
                }
            }

            p.link = r;
            q.link = p;
        }
    }

    public void showPolynomial(String name)
    {
        NodePolynomial p = head;
        boolean first = true;
        int auxCoefficient;

        System.out.print(name + "(x) = ");

        if (p == null) {
            System.out.println("0");
        } else {
            while (p != null) {
                if (p.coefficient > 0 && !first) {
                    System.out.print(" + ");
                }

                if (p.coefficient < 0) {
                    if (first) {
                        System.out.print("-");
                    } else {
                        System.out.print(" - ");
                    }
                }

                auxCoefficient = Math.abs(p.coefficient);

                if (p.exponent == 0) {
                    System.out.print(auxCoefficient);
                } else {
                    if (auxCoefficient != 1) {
                        System.out.print(auxCoefficient);
                    }

                    System.out.print("x");

                    if (p.exponent != 1) {
                        System.out.print("^" + p.exponent);
                    }
                }

                first = false;
                p = p.link;
            }

            System.out.println();
        }
    }

    public void sortDesc()
    {
        NodePolynomial p = head;
        NodePolynomial q;
        int auxCoefficient, auxExponent;

        while (p != null) {
            q = p.link;

            while (q != null) {
                if (p.exponent < q.exponent) {
                    auxCoefficient = p.coefficient;
                    auxExponent = p.exponent;

                    p.coefficient = q.coefficient;
                    p.exponent = q.exponent;

                    q.coefficient = auxCoefficient;
                    q.exponent = auxExponent;
                }

                q = q.link;
            }

            p = p.link;
        }

        ordered = true;
    }

    public void updateCoefficient(NodePolynomial dir, int coefficient)
    {
        dir.coefficient = coefficient;
    }

    public boolean deleteTerm(int exponent)
    {
        boolean sw = false;

        if (head != null) {
            if (head.exponent == exponent) {
                head = head.link;
                sw = true;
            } else {
                NodePolynomial q = head;
                NodePolynomial p = q.link;

                while (p != null && !sw) {
                    if (p.exponent == exponent) {
                        sw = true;
                    } else {
                        p = p.link;
                        q = q.link;
                    }
                }

                if (sw) {
                    q.link = p.link;
                }
            }
        }

        return sw;
    }

    public void addOrSumTerm(int coefficient, int exponent)
    {
        NodePolynomial dir;
        int newCoefficient;

        if (coefficient != 0) {
            dir = findTerm(exponent);

            if (dir == null) {
                createEndPolynomial(coefficient, exponent);
            } else {
                newCoefficient = dir.coefficient + coefficient;

                if (newCoefficient == 0) {
                    deleteTerm(exponent);
                } else {
                    dir.coefficient = newCoefficient;
                }
            }
        }
    }

    public PolynomialLSL sumPolynomial(PolynomialLSL pol2)
    {
        PolynomialLSL result = new PolynomialLSL();
        NodePolynomial p = head;

        while (p != null) {
            result.addOrSumTerm(p.coefficient, p.exponent);
            p = p.link;
        }

        p = pol2.getHead();

        while (p != null) {
            result.addOrSumTerm(p.coefficient, p.exponent);
            p = p.link;
        }

        result.sortDesc();

        return result;
    }

    public PolynomialLSL subtractPolynomial(PolynomialLSL pol2)
    {
        PolynomialLSL result = new PolynomialLSL();
        NodePolynomial p = head;

        while (p != null) {
            result.addOrSumTerm(p.coefficient, p.exponent);
            p = p.link;
        }

        p = pol2.getHead();

        while (p != null) {
            result.addOrSumTerm(-p.coefficient, p.exponent);
            p = p.link;
        }

        result.sortDesc();

        return result;
    }

    public double evaluatePolynomial(double a)
    {
        NodePolynomial p = head;
        double result = 0;

        while (p != null) {
            result = result + p.coefficient * Math.pow(a, p.exponent);
            p = p.link;
        }

        return result;
    }
}
