/*
 * Copyright 2017 TNG Technology Consulting GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tngtech.archunit.lang.syntax.elements;

import java.lang.annotation.Annotation;

import com.tngtech.archunit.PublicAPI;
import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.base.PackageMatcher;
import com.tngtech.archunit.core.domain.AccessTarget;
import com.tngtech.archunit.core.domain.JavaAccess;
import com.tngtech.archunit.core.domain.JavaAnnotation;
import com.tngtech.archunit.core.domain.JavaCall;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaCodeUnit;
import com.tngtech.archunit.core.domain.JavaConstructorCall;
import com.tngtech.archunit.core.domain.JavaFieldAccess;
import com.tngtech.archunit.core.domain.JavaMethodCall;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.domain.properties.HasName.Predicates;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import static com.tngtech.archunit.PublicAPI.Usage.ACCESS;

public interface ClassesShould {

    /**
     * Asserts that classes have a certain fully qualified class name.
     *
     * @param name The fully qualified class name
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction haveFullyQualifiedName(String name);

    /**
     * Asserts that classes don't have a certain fully qualified class name.
     *
     * @param name The fully qualified class name
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notHaveFullyQualifiedName(String name);

    /**
     * Asserts that classes have a certain simple class name.
     *
     * @param name The simple class name
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction haveSimpleName(String name);

    /**
     * Asserts that classes don't have a certain simple class name.
     *
     * @param name The simple class name
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notHaveSimpleName(String name);

    /**
     * Asserts that classes have a fully qualified class name matching a given regular expression.
     *
     * @param regex A regular expression
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction haveNameMatching(String regex);

    /**
     * Asserts that classes have a fully qualified class name not matching a given regular expression.
     *
     * @param regex A regular expression
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction haveNameNotMatching(String regex);

    /**
     * Asserts that classes reside in a package matching the supplied package identifier.
     *
     * @param packageIdentifier A string identifying packages, for details see {@link PackageMatcher}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction resideInAPackage(String packageIdentifier);

    /**
     * Asserts that classes reside in a package matching any of the supplied package identifiers.
     *
     * @param packageIdentifiers Strings identifying packages, for details see {@link PackageMatcher}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction resideInAnyPackage(String... packageIdentifiers);

    /**
     * Asserts that classes don't reside in a package matching the supplied package identifier.
     *
     * @param packageIdentifier A string identifying packages, for details see {@link PackageMatcher}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction resideOutsideOfPackage(String packageIdentifier);

    /**
     * Asserts that classes don't reside in a package matching any of the supplied package identifiers.
     *
     * @param packageIdentifiers Strings identifying packages, for details see {@link PackageMatcher}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction resideOutsideOfPackages(String... packageIdentifiers);

    /**
     * Asserts that classes are public.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction bePublic();

    /**
     * Asserts that classes are non-public.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBePublic();

    /**
     * Asserts that classes are protected.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beProtected();

    /**
     * Asserts that classes are non-protected.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeProtected();

    /**
     * Asserts that classes are package private.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction bePackagePrivate();

    /**
     * Asserts that classes are non-package private.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBePackagePrivate();

    /**
     * Asserts that classes are private.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction bePrivate();

    /**
     * Asserts that classes are non-private.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBePrivate();

    /**
     * Asserts that classes have a certain {@link JavaModifier} (e.g. {@link JavaModifier#ABSTRACT}).
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction haveModifier(JavaModifier modifier);

    /**
     * Asserts that classes don't have a certain {@link JavaModifier} (e.g. {@link JavaModifier#ABSTRACT}).
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notHaveModifier(JavaModifier modifier);

    /**
     * Asserts that classes are annotated with a certain type of annotation.
     *
     * @param annotationType Specific type of {@link Annotation}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAnnotatedWith(Class<? extends Annotation> annotationType);

    /**
     * Asserts that classes are not annotated with a certain type of annotation.
     *
     * @param annotationType Specific type of {@link Annotation}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAnnotatedWith(Class<? extends Annotation> annotationType);

    /**
     * Asserts that classes are annotated with a certain type of annotation.
     *
     * @param annotationTypeName Fully qualified class name of a specific type of {@link Annotation}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAnnotatedWith(String annotationTypeName);

    /**
     * Asserts that classes are not annotated with a certain type of annotation.
     *
     * @param annotationTypeName Fully qualified class name of a specific type of {@link Annotation}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAnnotatedWith(String annotationTypeName);

    /**
     * Asserts that classes are annotated with a certain annotation, where matching annotations are
     * determined by the supplied predicate.
     *
     * @param predicate A predicate defining matching {@link JavaAnnotation JavaAnnotations}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAnnotatedWith(DescribedPredicate<? super JavaAnnotation> predicate);

    /**
     * Asserts that classes are not annotated with a certain annotation, where matching annotations are
     * determined by the supplied predicate.
     *
     * @param predicate A predicate defining matching {@link JavaAnnotation JavaAnnotations}
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAnnotatedWith(DescribedPredicate<? super JavaAnnotation> predicate);

    /**
     * Asserts that classes implement a certain interface.
     *
     * @param type An interface imported classes should implement
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction implement(Class<?> type);

    /**
     * Asserts that classes don't implement a certain interface. This is the negation of {@link #implement(Class)}.
     *
     * @param type An interface imported classes should NOT implement
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notImplement(Class<?> type);

    /**
     * Asserts that classes implement a certain interface with the given type name. This is equivalent to
     * {@link #implement(Class)}, but doesn't depend on having a certain type on the classpath.
     *
     * @param typeName Name of an interface imported classes should implement
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction implement(String typeName);

    /**
     * Asserts that classes don't implement a certain interface with the given type name.
     * This is equivalent to {@link #notImplement(Class)}, but doesn't depend on having a certain
     * type on the classpath.
     *
     * @param typeName Name of an interface imported classes should NOT implement
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notImplement(String typeName);

    /**
     * Asserts that classes implement a certain interface matching the given predicate. For example, a call with
     * {@link Predicates#name(String)} would be equivalent to
     * {@link #implement(String)}, but the approach is a lot more generic.
     *
     * @param predicate A predicate identifying an interface imported classes should implement
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction implement(DescribedPredicate<? super JavaClass> predicate);

    /**
     * Asserts that classes don't implement a certain interface matching the given predicate.
     * This is the negation of {@link #implement(DescribedPredicate)}.
     *
     * @param predicate A predicate identifying an interface imported classes should NOT implement
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notImplement(DescribedPredicate<? super JavaClass> predicate);

    /**
     * Asserts that classes are assignable to a certain type (compare {@link Class#isAssignableFrom(Class)} to terminology).
     * A simple example for this predicate would be
     * <pre><code>
     *   assignableTo(Object.class).apply(importedStringClass); // --&gt; returns true
     *   assignableTo(String.class).apply(importedStringClass); // --&gt; returns true
     *   assignableTo(List.class).apply(importedStringClass); // --&gt; returns false
     * </code></pre>
     *
     * @param type An upper type bound to match imported classes against (imported subtypes will match)
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAssignableTo(Class<?> type);

    /**
     * Asserts that classes are not assignable to a certain type. This is the negation of {@link #beAssignableTo(Class)}.
     *
     * @param type An upper type bound imported classes should NOT have
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAssignableTo(Class<?> type);

    /**
     * Asserts that classes are assignable to a certain type with the given type name. This is equivalent to
     * {@link #beAssignableTo(Class)}, but doesn't depend on having a certain type on the classpath.
     *
     * @param typeName Name of an upper type bound to match imported classes against (imported subtypes will match)
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAssignableTo(String typeName);

    /**
     * Asserts that classes are not assignable to a certain type with the given type name.
     * This is equivalent to {@link #notBeAssignableTo(Class)}, but doesn't depend on having a certain
     * type on the classpath.
     *
     * @param typeName Name of an upper type bound imported classes should NOT have
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAssignableTo(String typeName);

    /**
     * Asserts that classes are assignable to a certain type matching the given predicate. For example, a call with
     * {@link Predicates#name(String)} would be equivalent to
     * {@link #beAssignableTo(String)}, but the approach is a lot more generic.
     *
     * @param predicate A predicate identifying an upper type bound to match imported classes against
     *                  (imported subtypes will match)
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAssignableTo(DescribedPredicate<? super JavaClass> predicate);

    /**
     * Asserts that classes are not assignable to a certain type matching the given predicate.
     * This is the negation of {@link #beAssignableTo(DescribedPredicate)}.
     *
     * @param predicate A predicate identifying an upper type bound imported classes should NOT have
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAssignableTo(DescribedPredicate<? super JavaClass> predicate);

    /**
     * Asserts that classes are assignable from a certain type (compare {@link Class#isAssignableFrom(Class)} to terminology).
     * This is roughly equivalent to the use of reflection:
     * <pre><code>
     *   someClass.class.isAssignableFrom(type);
     * </code></pre>
     * A simple example for this predicate would be
     * <pre><code>
     *   assignableFrom(ArrayList.class).apply(importedArrayListClass); // --&gt; returns true
     *   assignableFrom(ArrayList.class).apply(importedListClass); // --&gt; returns true
     *   assignableFrom(ArrayList.class).apply(importedStringClass); // --&gt; returns false
     * </code></pre>
     *
     * @param type A lower type bound to match imported classes against (imported supertypes will match)
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAssignableFrom(Class<?> type);

    /**
     * Asserts that classes are not assignable from a certain type. This is the negation of {@link #beAssignableFrom(Class)}.
     *
     * @param type A lower type bound imported classes should NOT have
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAssignableFrom(Class<?> type);

    /**
     * Asserts that classes are assignable from a certain type with the given type name. This is equivalent to
     * {@link #beAssignableFrom(Class)}, but doesn't depend on having a certain type on the classpath.
     *
     * @param typeName Name of a lower type bound to match imported classes against (imported supertypes will match)
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAssignableFrom(String typeName);

    /**
     * Asserts that classes are not assignable from a certain type with the given type name.
     * This is equivalent to {@link #notBeAssignableFrom(Class)}, but doesn't depend on having a certain
     * type on the classpath.
     *
     * @param typeName Name of a lower type bound imported classes should NOT have
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAssignableFrom(String typeName);

    /**
     * Asserts that classes are assignable from a certain type matching the given predicate. For example, a call with
     * {@link Predicates#name(String)} would be equivalent to
     * {@link #beAssignableFrom(String)}, but the approach is a lot more generic.
     *
     * @param predicate A predicate identifying a lower type bound to match imported classes against
     *                  (imported supertypes will match)
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beAssignableFrom(DescribedPredicate<? super JavaClass> predicate);

    /**
     * Asserts that classes are not assignable from a certain type matching the given predicate.
     * This is the negation of {@link #beAssignableFrom(DescribedPredicate)}.
     *
     * @param predicate A predicate identifying a lower type bound imported classes should NOT have
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeAssignableFrom(DescribedPredicate<? super JavaClass> predicate);

    /**
     * Matches against all accesses (setting or getting) of a specific field.
     *
     * @param owner     The class declaring the field
     * @param fieldName The name of the field to match
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction accessField(Class<?> owner, String fieldName);

    /**
     * Matches against all accesses (setting or getting) of a specific field.
     *
     * @param ownerName The fully qualified class name of the class declaring the field
     * @param fieldName The name of the field to match
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction accessField(String ownerName, String fieldName);

    /**
     * Matches against accessing fields, where origin (a method or constructor) and target (a field)
     * can be freely restricted by the supplied predicate.
     *
     * @param predicate Determines which {@link JavaFieldAccess JavaFieldAccesses} match the rule
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction accessFieldWhere(DescribedPredicate<? super JavaFieldAccess> predicate);

    /**
     * Matches against getting of a specific field (e.g. <code>return someClass.<b>someField</b>;</code>).
     *
     * @param owner     The class declaring the field
     * @param fieldName The name of the field to match
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction getField(Class<?> owner, String fieldName);

    /**
     * Matches against getting a specific field (e.g. <code>return someClass.<b>someField</b>;</code>).
     *
     * @param ownerName The fully qualified class name of the class declaring the field
     * @param fieldName The name of the field to match
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction getField(String ownerName, String fieldName);

    /**
     * Matches against getting of fields, where origin (a method or constructor) and target (a field)
     * can be freely restricted by the supplied predicate.
     *
     * @param predicate Determines which {@link JavaFieldAccess JavaFieldAccesses} match the rule
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction getFieldWhere(DescribedPredicate<? super JavaFieldAccess> predicate);

    /**
     * Matches against setting a specific field (e.g. <code>someClass.<b>someField</b> = newValue;</code>).
     *
     * @param owner     The class declaring the field
     * @param fieldName The name of the field to match
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction setField(Class<?> owner, String fieldName);

    /**
     * Matches against setting a specific field (e.g. <code>someClass.<b>someField</b> = newValue;</code>).
     *
     * @param ownerName The fully qualified class name of the class declaring the field
     * @param fieldName The name of the field to match
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction setField(String ownerName, String fieldName);

    /**
     * Matches against setting of fields, where origin (a method or constructor) and target (a field)
     * can be freely restricted by the supplied predicate.
     *
     * @param predicate Determines which {@link JavaFieldAccess JavaFieldAccesses} match the rule
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction setFieldWhere(DescribedPredicate<? super JavaFieldAccess> predicate);

    /**
     * Matches against a method call to a specific method (e.g. <code>someClass.<b>call()</b>;</code>).
     *
     * @param owner          Class declaring the method
     * @param methodName     The method name to match against
     * @param parameterTypes The parameter types of the respective method
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction callMethod(Class<?> owner, String methodName, Class<?>... parameterTypes);

    /**
     * Matches against method call to a specific method (e.g. <code>someClass.<b>call()</b>;</code>).
     *
     * @param ownerName          The fully qualified class name declaring the method
     * @param methodName         The method name to match against
     * @param parameterTypeNames The fully qualified parameter type names
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction callMethod(String ownerName, String methodName, String... parameterTypeNames);

    /**
     * Matches against method calls where origin (a method or constructor) and target (a method)
     * can be freely restricted by the supplied predicate.
     *
     * @param predicate Determines which {@link JavaMethodCall JavaMethodCalls} match the rule
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction callMethodWhere(DescribedPredicate<? super JavaMethodCall> predicate);

    /**
     * Matches against a constructor call to a specific constructor (e.g. <code><b>new SomeClass()</b>;</code>).
     *
     * @param owner          Class declaring the constructor
     * @param parameterTypes The parameter types of the respective constructor
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction callConstructor(Class<?> owner, Class<?>... parameterTypes);

    /**
     * Matches against constructor call to a specific constructor (e.g. <code><b>new SomeClass()</b>;</code>).
     *
     * @param ownerName          The fully qualified class name declaring the constructor
     * @param parameterTypeNames The fully qualified parameter type names
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction callConstructor(String ownerName, String... parameterTypeNames);

    /**
     * Matches against constructor calls where origin (a method or constructor) and target (a constructor)
     * can be freely restricted by the supplied predicate.
     *
     * @param predicate Determines which {@link JavaConstructorCall JavaConstructorCalls} match the rule
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction callConstructorWhere(DescribedPredicate<? super JavaConstructorCall> predicate);

    /**
     * Matches against access of arbitrary targets (compare {@link AccessTarget})
     * where origin (a method or constructor) and target (a field, method or constructor) can be freely restricted
     * by the supplied predicate.
     *
     * @param predicate Determines which {@link JavaAccess JavaAccesses} match the rule
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction accessTargetWhere(DescribedPredicate<? super JavaAccess<?>> predicate);

    /**
     * Matches against code unit calls (compare {@link JavaCodeUnit}) where origin (a code unit)
     * and target (a code unit) can be freely restricted by the supplied predicate.
     *
     * @param predicate Determines which {@link JavaCall JavaCalls} match the rule
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction callCodeUnitWhere(DescribedPredicate<? super JavaCall<?>> predicate);

    /**
     * Asserts that all classes selected by this rule access certain classes.<br>
     * NOTE: This usually makes more sense the negated way, e.g.
     * <p>
     * <pre><code>
     * {@link ArchRuleDefinition#noClasses() noClasses()}.{@link GivenClasses#should() should()}.{@link #accessClassesThat()}.{@link ClassesShouldThat#haveFullyQualifiedName(String) haveFullyQualifiedName(String)}
     * </code></pre>
     *
     * @return A syntax element that allows choosing which classes should be accessed
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldThat accessClassesThat();

    /**
     * Asserts that all classes selected by this rule access certain classes.<br>
     * NOTE: This usually makes more sense the negated way, e.g.
     * <p>
     * <pre><code>
     * {@link ArchRuleDefinition#noClasses() noClasses()}.{@link GivenClasses#should() should()}.{@link #accessClassesThat(DescribedPredicate) accessClassesThat(myPredicate)}
     * </code></pre>
     *
     * @param predicate Determines which {@link JavaClass JavaClasses} match the access target
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction accessClassesThat(DescribedPredicate<? super JavaClass> predicate);

    /**
     * @return A syntax element that allows restricting how classes should be accessed
     * <br>E.g.
     * <pre><code>
     * {@link #onlyBeAccessed()}.{@link OnlyBeAccessedSpecification#byAnyPackage(String...) byAnyPackage(String...)}
     * </code></pre>
     */
    @PublicAPI(usage = ACCESS)
    OnlyBeAccessedSpecification<ClassesShouldConjunction> onlyBeAccessed();


    /**
     * Asserts that classes are interfaces.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction beInterfaces();

    /**
     * Asserts that classes are not interfaces.
     *
     * @return A syntax element that can either be used as working rule, or to continue specifying a more complex rule
     */
    @PublicAPI(usage = ACCESS)
    ClassesShouldConjunction notBeInterfaces();
}
